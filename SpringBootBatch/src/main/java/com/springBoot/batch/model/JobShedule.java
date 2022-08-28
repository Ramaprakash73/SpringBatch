package com.springBoot.batch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_shedule")
public class JobShedule {
	@Id
	@GeneratedValue
	private Integer jobId;
	private String jobName;
	private  String cronExpr;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getCronExpr() {
		return cronExpr;
	}

	public void setCronExpr(String cronExpr) {
		this.cronExpr = cronExpr;
	}

	@Override
	public String toString() {
		return "Cronmodel [jobId=" + jobId + ", jobName=" + jobName + ", cronExpr=" + cronExpr + "]";
	}

}
