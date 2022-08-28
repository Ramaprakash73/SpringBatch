package com.springBoot.batch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.batch.model.JobShedule;
import com.springBoot.batch.service.JobSheduleService;

@RestController
@RequestMapping("/cron")
public class JobSheduleController {
	@Autowired
	private JobSheduleService cronService;

	@PostMapping
	public ResponseEntity<String> saveCron(@RequestBody JobShedule cronModel) {
		cronService.saveCron(cronModel);

		return new ResponseEntity<String>("cron was saved", HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<JobShedule>> getperson() {

		List<JobShedule> p1 = cronService.getAllCron();

		return new ResponseEntity<List<JobShedule>>(p1, HttpStatus.OK);

	}

	@GetMapping(path="/{jobId}")
	public ResponseEntity<JobShedule> getCronById(@PathVariable Integer jobId) {
		
		System.out.println("INSIDE getCronById ");
		JobShedule cron = cronService.getcron(jobId);
		System.out.println("INSIDE AFTER SELECT ");
		System.out.println("Cronmodel "+cron);
		return new ResponseEntity<JobShedule>(HttpStatus.OK);
	}

}
