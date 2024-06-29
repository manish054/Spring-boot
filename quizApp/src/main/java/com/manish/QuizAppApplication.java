package com.manish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.manish.modal.Question;

@SpringBootApplication
public class QuizAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(QuizAppApplication.class, args);
		
//		Question q1 = context.getBean(Question.class);
		
		
	}

}
