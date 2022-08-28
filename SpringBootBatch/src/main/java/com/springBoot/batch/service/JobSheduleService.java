package com.springBoot.batch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.batch.model.JobShedule;
import com.springBoot.batch.repo.JobSheduleRepo;

@Service
public class JobSheduleService {
	
	@Autowired
	private JobSheduleRepo cronDao;
	
	
	public JobShedule getcron(Integer jobId) {
		return cronDao.getById(jobId);
		
	}
	
	public void saveCron(JobShedule cm) {
		cronDao.save(cm);
	}
	
	public List<JobShedule> getAllCron(){
		return cronDao.findAll();
	}
	

}
