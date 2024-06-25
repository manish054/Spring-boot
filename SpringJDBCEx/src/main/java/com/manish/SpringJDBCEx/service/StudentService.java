package com.manish.SpringJDBCEx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manish.SpringJDBCEx.model.Student;
import com.manish.SpringJDBCEx.repo.StudentRepo;

@Service
public class StudentService {
	
	private StudentRepo repo;
	
	public StudentRepo getRepo() {
		return repo;
	}
	
	@Autowired
	public void setRepo(StudentRepo repo) {
		this.repo = repo;
	}

	public void addStudent(Student st) {
		repo.save(st);
		System.out.println("Student added");
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
}
