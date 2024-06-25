package com.manish.springDataJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.manish.springDataJPA.model.Student;
import com.manish.springDataJPA.repo.StudentRepo;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);
		
		s1.setRoll(101);
		s1.setName("Manish");
		s1.setMarks(45);
		
		s2.setRoll(102);
		s2.setName("Bittu");
		s2.setMarks(50);
		
		s3.setRoll(103);
		s3.setName("Princy");
		s3.setMarks(55);
		
		StudentRepo repo = context.getBean(StudentRepo.class);
//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);
		
		System.out.println(repo.findAll());
		System.out.println(repo.findByName("Bittu"));
		System.out.println(repo.findByMarks(50));
		System.out.println(repo.findByMarksGreaterThanEqual(50));
		
		repo.save(s3);
//		repo.delete(s2);
		repo.deleteById(102);
	}

}
