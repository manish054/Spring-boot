package com.manish.SpringJDBCEx;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.manish.SpringJDBCEx.model.Student;
import com.manish.SpringJDBCEx.service.StudentService;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);
		Student st = context.getBean(Student.class);
		st.setRoll(1040);
		st.setName("Mayank");
		st.setMarks(87);
		
		StudentService service = context.getBean(StudentService.class);
		service.addStudent(st);
		
		List<Student> students = service.getAllStudents();
		System.out.println(students);
	}

}
