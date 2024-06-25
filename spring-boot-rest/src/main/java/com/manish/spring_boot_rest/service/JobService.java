package com.manish.spring_boot_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.spring_boot_rest.modal.JobDetails;
import com.manish.spring_boot_rest.repo.*;

@Service
public class JobService {
	
	private JobRepo repo;
	public JobRepo getRepo() {
		return repo;
	}
	
	@Autowired
	public void setRepo(JobRepo repo) {
		this.repo = repo;
	}
	
	public void addjob(JobDetails job) {
		repo.addJob(job);
	}
	
	public List<JobDetails> getAllJobs() {
		return repo.getAllJobs();
	}

	public JobDetails getJob(String job_id) {
		// TODO Auto-generated method stub
		
		return repo.getJob(job_id);
	}
	
	public void deleteJob(String job_id) {
		repo.delete(job_id);
	}

	public JobDetails updateJob(JobDetails job) {
		// TODO Auto-generated method stub
		return repo.updateJob(job);
	}

}
