package com.manish.spring_boot_rest.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.manish.spring_boot_rest.modal.JobDetails;

@Repository
public class JobRepo {
	List<JobDetails> jobs = new ArrayList<>(Arrays.asList(
			new JobDetails("Java Developer", "1", 2, new ArrayList<>(Arrays.asList("Java"))),
			new JobDetails("Python Developer", "2", 2, new ArrayList<>(Arrays.asList("Python"))),
			new JobDetails(".Net Developer", "3", 2, new ArrayList<>(Arrays.asList("C#")))
			));
	
	public List<JobDetails> getAllJobs(){
		return jobs;
	}
	
	public void addJob(JobDetails job) {
		jobs.add(job);
		for(JobDetails jo:jobs)
		System.out.println(jo.getPost()+" "+jo.getjob_id()+" "+jo.getexperience()+" "+jo.getSkill());
	}

	public JobDetails getJob(String job_id) {
		// TODO Auto-generated method stub
		for(JobDetails job: jobs) {
			if(job.getjob_id().equals(job_id))
				return job;
		}
		return null;
	}

	public void delete(String job_id) {
		// TODO Auto-generated method stub
		for(JobDetails job: jobs) {
			if(job.getjob_id().equals(job_id))
				jobs.remove(job);
		}
	}

	public JobDetails updateJob(JobDetails job) {
		// TODO Auto-generated method stub
		for(JobDetails job1: jobs) {
			if(job1.getjob_id().equals(job.getjob_id())) {
				job1.setjob_id(job.getjob_id());
				job1.setPost(job.getPost());
				job1.setexperience(job.getexperience());
				job1.setSkill(job.getSkill());
				return job1;
			}
		}
		return null;
	}
}
