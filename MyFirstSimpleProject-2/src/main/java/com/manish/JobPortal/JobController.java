package com.manish.JobPortal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.manish.JobPortal.modal.JobDetails;
import com.manish.JobPortal.service.JobService;



@Controller
public class JobController {
	
	@Autowired
	JobService service;
	
	@GetMapping({"/","home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/addjob")
	public String addJob() {
//		JobDetails jobdetails = new JobDetails();
//		service.addjob(job);
		return "addjob";
	}
	
	@GetMapping("/viewjobs/{jobId}")
	public List<JobDetails> viewJobs(Model model) {
//		List<JobDetails> jobs = new ArrayList<>();
//		jobs = service.getAllJobs();
//		model.addAttribute("jobPosts", jobs);
		System.out.print(service.getAllJobs());
		return service.getAllJobs();
	}
	
	@PostMapping("/handleForm")
	public String handleForm(JobDetails jobDetails) {
		service.addjob(jobDetails);
		System.out.println(jobDetails.getjob_id()+" "+jobDetails.getPost()+" "+jobDetails.getexperience()+" "+jobDetails.getSkill());
		return "success";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/load")
	public String loadData() {
		service.load();
		return "Success";
	}
}
