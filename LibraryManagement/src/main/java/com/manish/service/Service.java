package com.manish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manish.model.Book;
import com.manish.repo.Repo;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private Repo repo;
	
	public void addBook(Book book) {
		repo.save(book);
	}
	
	public Book findBook(String bookId) {
		return repo.findById(bookId).orElse(new Book());
	}
	
	public List<Book> findAllBook(){
		return repo.findAll();
	}
	
	public void updateBook(Book book) {
		repo.save(book);
	}
	
	public void deleteBook(String bookId) {
		repo.deleteById(bookId);
	}
}
