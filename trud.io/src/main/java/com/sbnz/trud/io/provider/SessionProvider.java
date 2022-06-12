package com.sbnz.trud.io.provider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.service.contracts.IPregnancyService;

import java.util.HashMap;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Component
public class SessionProvider {
	private static HashMap<Integer, KieSession> sessions = new HashMap<Integer, KieSession>();
	private KieContainer kieContainer;
	private IPregnancyService pregnancyService;
	
	@Autowired
	public SessionProvider(
			KieContainer kieContainer,
			IPregnancyService pregnancyService) 
	{
		this.kieContainer = kieContainer;
		this.pregnancyService = pregnancyService;
	}
	
	public KieSession getSession(int pregnancyId) {
		if(!sessions.containsKey(pregnancyId)) {
			KieSession kieSession = kieContainer.newKieSession("ctgKBaseSession");
			Pregnancy pregnancy = pregnancyService.findById(pregnancyId);
			kieSession.insert(pregnancy);
			
			sessions.put(pregnancyId, kieSession);
		}
		
		return sessions.get(pregnancyId);
	}
	
	public void disposeSession(int pregnancyId) {
		if(!sessions.containsKey(pregnancyId)) {
			return;
		}
		
		KieSession session = sessions.get(pregnancyId);
		session.dispose();
		
		sessions.remove(pregnancyId);
	}
}
