package com.springBoot.batch;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.springBoot.batch.repo.JobSheduleRepo;

@Lazy(false)
@Component
@EnableScheduling
public class TimeSheetImportTask implements SchedulingConfigurer {
   
    @Autowired 
	private JobSheduleRepo jobSheduleRepo;
    private String cron = "0/5 * * * * ?";
    private String jobName="TimeSheetImport";
    private Date startDate = new Date();
    private Date endDate = new Date();
    private Date currentExecutionTime;
    private Date nextExecutionTime;
    private String oldCron;

    @Bean 
	public String getCronValue() {
		return jobSheduleRepo.findByJobName(jobName).get(0).getCronExpr();
	} 
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(() -> {
        	startDate=new Date();
        	currentExecutionTime=startDate;
        	ProcessTimeSheetImport();
        	endDate = new Date();
        	updateCronExpression();
           
        }, triggerContext -> {
            CronTrigger trigger = new CronTrigger(cron);
            nextExecutionTime = trigger.nextExecutionTime(triggerContext);
            displayJobExecutionDetails();
            return nextExecutionTime;
        });
    }
    public void updateCronExpression() {
		String updatedCron=jobSheduleRepo.findByJobName(jobName).get(0).getCronExpr();
		this.oldCron=cron;
        this.cron = updatedCron;
    }
	private void displayJobExecutionDetails() {
		System.out.println("jobName		:"+jobName);
        System.out.println("startDate	:"+startDate);
        System.out.println("endDate		:"+endDate);
        System.out.println("oldCron		:"+oldCron);
        System.out.println("cron		:"+cron);
        System.out.println("currentExecutionTime  :"+currentExecutionTime);
        System.out.println("nextExecutionTime     :"+nextExecutionTime);
	}
    public String getCron() {
        return this.cron;
    }
    
    public void ProcessTimeSheetImport() {
    	try {
			for(int i=1;i<=2;i++) {
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    }
}