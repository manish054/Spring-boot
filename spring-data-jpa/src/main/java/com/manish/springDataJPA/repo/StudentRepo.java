package com.manish.springDataJPA.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manish.springDataJPA.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	
	//if we dont write query then also it will work as JPA uses Data Specific language
	@Query("select s from Student s where s.name = ?1")
	List<Student> findByName(String name);
	
	//find by marks
	List<Student> findByMarks(int marks);
	
	//find by condition
	List<Student> findByMarksGreaterThanEqual(int marks);
}
