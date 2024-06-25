package com.manish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.manish.model.Book;
import com.manish.service.Service;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LibraryManagementApplication.class, args);
		
		Book book1 = context.getBean(Book.class);
		book1.setId("B001");
		book1.setName("Wings of Fire");
		book1.setAuthor("APJ Kalam");
		book1.setCost("299");
		
		Service service = context.getBean(Service.class);
		service.addBook(book1);
	}

}
