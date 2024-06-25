package com.manish.JobPortal.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.JobPortal.modal.JobDetails;
import com.manish.JobPortal.repo.JobRepo;

@Service
public class JobService {
	
	@Autowired
	private JobRepo repo;
	public JobRepo getRepo() {
		return repo;
	}
	
	@Autowired
	public void setRepo(JobRepo repo) {
		this.repo = repo;
	}
	
	public void addjob(JobDetails job) {
		repo.save(job);
	}
	
	public List<JobDetails> getAllJobs() {
		return repo.findAll();
	}
	
	public JobDetails getJob(String jobId) {
		return repo.findById(jobId).orElse(new JobDetails());
	}
	
	public void updateJob(JobDetails job) {
		repo.save(job);
	}
	
	public void deleteJob(String jobId) {
		repo.deleteById(jobId);
	}

	public void load() {
		// TODO Auto-generated method stub
		List<JobDetails> jobs = new ArrayList<>(Arrays.asList(
				new JobDetails("Java Developer", "1234", 2, new ArrayList<>(Arrays.asList("Java"))),
				new JobDetails("Python Developer", "2345", 2, new ArrayList<>(Arrays.asList("Python"))),
				new JobDetails(".Net Developer", "3456", 2, new ArrayList<>(Arrays.asList("C#"))),
				new JobDetails("BhaiLang Developer", "6789", 2, new ArrayList<>(Arrays.asList("Bhai Lang")))
				));
		repo.saveAll(jobs);
	}
}
