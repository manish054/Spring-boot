package com.manish.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manish.modal.Student;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.ArrayList;
@RestController
public class StudentController {
	List<Student> students = new ArrayList<>(List.of(
			new Student(1, "Manish", "Java"),
			new Student(2, "Bittu", "JS")
			));
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student){
		students.add(student);
		return student;
	}
}
