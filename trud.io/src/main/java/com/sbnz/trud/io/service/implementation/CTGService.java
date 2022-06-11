package com.sbnz.trud.io.service.implementation;

import java.util.Collection;
import java.util.Date;

import org.drools.core.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.event.CTGEnded;
import com.sbnz.trud.io.event.ContrationValueEvent;
import com.sbnz.trud.io.event.FetalHeartRateEvent;
import com.sbnz.trud.io.model.CTG;
import com.sbnz.trud.io.model.CTGStatus;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.provider.SessionProvider;
import com.sbnz.trud.io.service.contracts.ICTGService;
import com.sbnz.trud.io.service.contracts.INotificationService;
import com.sbnz.trud.io.service.contracts.IPregnancyService;


@Service
public class CTGService extends GenericService<CTG> implements ICTGService {

	private SessionProvider sessionProvider;
	private INotificationService notificationService;
	private IPregnancyService pregnancyService;
	
	@Autowired
	public CTGService(SessionProvider sessionProvider, IPregnancyService pregnancyService, INotificationService notificationService) 
	{
		this.sessionProvider = sessionProvider;
		this.pregnancyService = pregnancyService;
		this.notificationService = notificationService;
	}
	
	@Override
	public void monitorCtg(int pregnancyId, float value, Date timestamp) throws Exception {
		KieSession session = sessionProvider.getSession(pregnancyId);
		FetalHeartRateEvent fhr = new FetalHeartRateEvent(value, false, timestamp);
		session.insert(fhr);
		
		session.getAgenda().getAgendaGroup("ctgMonitoring").setFocus();
		session.fireAllRules();
		
	}
	
	@Override 
	public void monitorMother(int pregnancyId, int value, Date timestamp) {
		KieSession session = sessionProvider.getSession(pregnancyId);
		ContrationValueEvent cve = new ContrationValueEvent(value,false, timestamp);
		
		session.insert(cve);
		session.getAgenda().getAgendaGroup("ctgMonitoring").setFocus();
		session.fireAllRules();
	}
	
	@Override
	public CTG endCtg(int pregnancyId) throws Exception {
		KieSession session = sessionProvider.getSession(pregnancyId);
		
		CTGEnded ended = new CTGEnded(true);
		session.insert(ended);
		
		session.getAgenda().getAgendaGroup("ctgMonitoring").setFocus();
		session.fireAllRules();
		
		sessionProvider.disposeSession(pregnancyId);
		
		Collection<?> ctgs= session.getObjects(new ClassObjectFilter(CTG.class));
		
		CTG newCTG = (CTG) ctgs.iterator().next();
		newCTG = this.create(newCTG);
		
		Pregnancy pregnancy = pregnancyService.findById(pregnancyId);
		pregnancy.getCtg().add(newCTG);
		
		pregnancyService.update(pregnancy);
		
		return newCTG;
	}

	@Override
	public void startCtg(int pregnancyId) throws Exception {
		KieSession session = sessionProvider.getSession(pregnancyId);
		
		session.setGlobal("notificationService", notificationService);
		CTG ctg = new CTG();
		ctg.setVariabiltyStatus(CTGStatus.REASSURING);
		ctg.setFhrStatus(CTGStatus.REASSURING);
		ctg.setResult(CTGStatus.REASSURING);
		
		session.insert(ctg);
	
	}

}
