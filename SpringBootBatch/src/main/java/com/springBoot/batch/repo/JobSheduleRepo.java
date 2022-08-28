package com.springBoot.batch.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.batch.model.JobShedule;

@Repository
public interface JobSheduleRepo extends JpaRepository<JobShedule, Integer>{
	
	 List<JobShedule> findByJobName(String jobName);

}
