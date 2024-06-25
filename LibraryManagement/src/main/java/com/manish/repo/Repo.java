package com.manish.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manish.model.Book;

@Repository
public interface Repo extends JpaRepository<Book, String>{
	
}
