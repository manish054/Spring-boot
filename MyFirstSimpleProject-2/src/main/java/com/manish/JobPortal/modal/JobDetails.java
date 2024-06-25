package com.manish.JobPortal.modal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Component
@Entity
public class JobDetails {
	
	private String post;
	
	@Id
	private String job_id;
	private int experience;
	private List<String> skill;
	
	public JobDetails(String post, String job_id, int experience, ArrayList skill) {
		// TODO Auto-generated constructor stub
		this.post = post;
		this.job_id = job_id;
		this.experience = experience;
		this.skill = skill;
	}
	
	public JobDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getjob_id() {
		return job_id;
	}
	public void setjob_id(String job_id) {
		this.job_id = job_id;
	}
	public int getexperience() {
		return experience;
	}
	public void setexperience(int experience) {
		this.experience = experience;
	}
	public List<String> getSkill() {
		return skill;
	}
	public void setSkill(List<String> skill) {
		this.skill = skill;
	}
}
