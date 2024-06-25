package com.manish.JobPortal.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manish.JobPortal.modal.JobDetails;

@Repository
public interface JobRepo extends JpaRepository<JobDetails, String>{
	
}

//List<JobDetails> jobs = new ArrayList<>(Arrays.asList(
//		new JobDetails("Java Developer", "1234", 2, new ArrayList<>(Arrays.asList("Java"))),
//		new JobDetails("Python Developer", "2345", 2, new ArrayList<>(Arrays.asList("Python"))),
//		new JobDetails(".Net Developer", "3456", 2, new ArrayList<>(Arrays.asList("C#")))
//		));
//
//public List<JobDetails> getAllJobs(){
//	return jobs;
//}
//
//public void addJob(JobDetails job) {
//	jobs.add(job);
//	for(JobDetails jo:jobs)
//	System.out.println(jo.getPost()+" "+jo.getjob_id()+" "+jo.getexperience()+" "+jo.getSkill());
//}