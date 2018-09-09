package com.wyx.proj.scheduler;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTest {

    @Value("${scheduleTask.switch}")
    private String taskSwitch;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void test(){
        if(taskSwitch.equals("open")){

            System.out.println("----------111----->>");
        }
    }
}
