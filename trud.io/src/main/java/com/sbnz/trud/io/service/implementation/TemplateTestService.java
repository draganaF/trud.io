package com.sbnz.trud.io.service.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.codehaus.plexus.util.cli.CommandLineUtils;
import org.drools.template.ObjectDataCompiler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.apiContracts.request.TemplateTestRule;
import com.sbnz.trud.io.utils.TemplateConvertor;

@Service
public class TemplateTestService {
	
	 @Value("${templatePath}")
	 private String templatePath;
	 @Value("${projectPath}")
	 private String projectPath;
	 @Value("${kjarPath}")
	 private String kjarPath;
	 @Value("${drtPath}")
	 private String drtPath;

	 public TemplateTestService() {}
	 
	 public void template(TemplateTestRule doubleTestRule) throws IOException {
		File drtFile = new File(drtPath);
		InputStream template = new FileInputStream(drtFile);
		List<TemplateTestRule> data = new ArrayList<>();
		data.add(doubleTestRule);
		data.add(TemplateConvertor.convertDoubleTestRule(doubleTestRule));


		ObjectDataCompiler converter = new ObjectDataCompiler();
		String drl = converter.compile(data, template);

		String header = drl.substring(drl.indexOf("package"), drl.indexOf("dialect"));
		
		String body = drl.substring(drl.indexOf("rule"));
		
		drl = header.concat(body);
		
        try {
            Files.write(Paths.get(templatePath), drl.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            
        }

        mavenInstall();
        
    }
	
	 public void mavenInstall() throws IOException {

        InvocationRequest requestKjar = new DefaultInvocationRequest();
        requestKjar.setPomFile( new File( kjarPath ) );
        requestKjar.setGoals( Arrays.asList( "clean", "install" ) );
        
        InvocationRequest requestProject = new DefaultInvocationRequest();
        requestProject.setPomFile( new File( projectPath ) );
        requestProject.setGoals( Arrays.asList( "clean", "package" ) );
        

        Properties envars = CommandLineUtils.getSystemEnvVars();
        String mavenHome = envars.getProperty( "M2_HOME" );
     

        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(mavenHome));
        try {
            invoker.execute( requestKjar );
            invoker.execute( requestProject );
        } catch (MavenInvocationException e) {
            e.printStackTrace();
        }
	   }
}
