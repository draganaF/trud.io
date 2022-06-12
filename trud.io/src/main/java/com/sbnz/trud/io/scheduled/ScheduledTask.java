package com.sbnz.trud.io.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sbnz.trud.io.model.OgttTest;
import com.sbnz.trud.io.service.contracts.IGestationalDiabetesService;

@Component
public class ScheduledTask {

    private IGestationalDiabetesService diabetesService;

    public ScheduledTask(IGestationalDiabetesService diabetesService) {
        this.diabetesService = diabetesService;
    }

    @Scheduled(cron = "0 1 1 * * ?")
    @Transactional
    public void earlyOgttTest() throws Exception {
        this.diabetesService.earlyOgttTest(new OgttTest());
    }
}
