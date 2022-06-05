package com.sbnz.trud.io.service.implementation;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.apiContracts.request.TemplateTestRule;
import com.sbnz.trud.io.model.DoubleTest;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.repository.AgeRiskRepository;
import com.sbnz.trud.io.repository.DoubleTestRepository;
import com.sbnz.trud.io.repository.PregnancyRepository;
import com.sbnz.trud.io.repository.WeeklyParametersRepository;
import com.sbnz.trud.io.service.contracts.IDoubleTestService;

import utils.TemplateConvertor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.maven.shared.invoker.*;
import org.codehaus.plexus.util.cli.CommandLineUtils;

import java.nio.file.StandardOpenOption;
import java.util.Arrays;

@Service
public class DoubleTestService extends GenericService<DoubleTest> implements IDoubleTestService{

	 private DoubleTestRepository doubleTestRepository;
	 private PregnancyRepository pregnancyRepository;
	 private AgeRiskRepository ageRiskRepository;
	 private WeeklyParametersRepository weeklyParametersRepository;
	 private final KieContainer kieContainer;
	 @Value("${templatePath}")
	 private String templatePath;
	
	@Autowired
	public DoubleTestService(DoubleTestRepository doubleTestRepository, 
			PregnancyRepository pregnancyRepository, AgeRiskRepository ageRiskRepository,
			WeeklyParametersRepository weeklyParametersRepository, KieContainer kieContainer) {
		this.doubleTestRepository = doubleTestRepository;
		this.pregnancyRepository = pregnancyRepository;
		this.ageRiskRepository = ageRiskRepository;
		this.weeklyParametersRepository = weeklyParametersRepository;
		this.kieContainer = kieContainer;
	}
	
	@Override
	public DoubleTest create(DoubleTest doubleTest) {
		return doubleTestRepository.save(doubleTest);
	}

	@Override
	public DoubleTest addDoubleTest(Integer pregnancyId, DoubleTest doubleTest) {
		DoubleTest createdDoubleTest = create(doubleTest);
		Pregnancy pregnancy = pregnancyRepository.findById(pregnancyId).orElse(null);
		pregnancy.setDoubleTest(createdDoubleTest);
		pregnancyRepository.save(pregnancy);
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(pregnancy);
		kieSession.insert(createdDoubleTest);
		ageRiskRepository.findAll().forEach(age -> kieSession.insert(age));
		weeklyParametersRepository.findAll().forEach(week -> kieSession.insert(week));
		kieSession.getAgenda().getAgendaGroup("doubleTest").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		return doubleTestRepository.save(createdDoubleTest);
	}

	@Override
	public void template(TemplateTestRule doubleTestRule) throws IOException {
		InputStream template = DoubleTestService.class.getResourceAsStream("/templates/template.drt");
		List<TemplateTestRule> data = new ArrayList<>();
		data.add(doubleTestRule);
		data.add(TemplateConvertor.convertDoubleTestRule(doubleTestRule));


		ObjectDataCompiler converter = new ObjectDataCompiler();
		String drl = converter.compile(data, template);

		String header = drl.substring(drl.indexOf("package"), drl.indexOf("dialect"));
		
		String body = drl.substring(drl.indexOf("rule"));
		
		drl = header.concat(body);
		
        try {
            Files.write(Paths.get("C:/Users/Lenovo/Desktop/sbnz/trud.io/trud.io.kjar/src/main/resources/trud/io/kjar/template.drl"), drl.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            
        }

        mavenInstall();
        
    }
	
	 public void mavenInstall() throws IOException {

		String kjarPath = "C:/Users/Lenovo/Desktop/sbnz/trud.io/trud.io.kjar/pom.xml";
        InvocationRequest requestKjar = new DefaultInvocationRequest();
        requestKjar.setPomFile( new File( kjarPath ) );
        requestKjar.setGoals( Arrays.asList( "clean", "install" ) );
        
        String projectPath = "C:/Users/Lenovo/Desktop/sbnz/trud.io/trud.io/pom.xml";
        InvocationRequest requestProject = new DefaultInvocationRequest();
        requestProject.setPomFile( new File( projectPath ) );
        requestProject.setGoals( Arrays.asList( "clean", "package" ) );
        

        Properties envars = CommandLineUtils.getSystemEnvVars();
        String mavenHome = envars.getProperty( "M2_HOME" );
     

        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(mavenHome));
        try {
            invoker.execute( requestKjar );
//            invoker.execute( requestProject );
        } catch (MavenInvocationException e) {
            e.printStackTrace();
        }
	   }
 
}
