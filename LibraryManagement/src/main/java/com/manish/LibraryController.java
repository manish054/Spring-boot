package com.manish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manish.model.Book;
import com.manish.service.Service;

@RestController
public class LibraryController {
	
	@Autowired
	private Service service;
	

	@GetMapping("book")
	public List<Book> allBooks() {
		return service.findAllBook();
	}
	
	@PostMapping("book")
	public void addBook(@RequestBody Book book) {
		service.addBook(book);
	}
	
	@PutMapping("book")
	public void updateBook(@RequestBody Book book) {
		service.addBook(book);
	}
	
	@GetMapping("book/{bookId}")
	public Book getBook(@PathVariable("bookId") String Id) {
		return service.findBook(Id);
	}
	
	@DeleteMapping("book/{bookId}")
	public void deleteBook(@PathVariable("bookId") String Id) {
		service.deleteBook(Id);
	}
	
}
