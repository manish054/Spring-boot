package com.manish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepo repo;
	
	@GetMapping("/getStudents")
	public List<Student> getStudents(){
		return repo.findAll();
	}
	
	@GetMapping("/addStudent")
	public String addStudent() {
		Student s = new Student();
		s.setName("Pranay");
		s.setAge(24);
		repo.save(s);
		return "Added";
	}
}
