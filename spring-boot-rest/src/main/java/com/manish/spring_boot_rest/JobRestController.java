package com.manish.spring_boot_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manish.spring_boot_rest.service.JobService;
import com.manish.spring_boot_rest.modal.JobDetails;

@RestController
public class JobRestController {
	
	@Autowired
	private JobService service;
	
	@GetMapping("jobs")
	public List<JobDetails> getAllJobs(){
		return service.getAllJobs();
	}
	
	@GetMapping("job/{job_id}")
	public JobDetails getJobById(@PathVariable("job_id") String job_id) {
		return service.getJob(job_id);
	}
	
	@PostMapping("job")
	public void addJob(@RequestBody JobDetails job) {
		service.addjob(job);
	}
	
	@PutMapping("job")
	public JobDetails updateJob(@RequestBody JobDetails job) {
		return service.updateJob(job);
	}
	
	@DeleteMapping("job/{job_id}")
	public void delete(@PathVariable String job_id) {
		service.deleteJob(job_id);
	}
}
