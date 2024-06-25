package com.manish.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;

@Component
@Scope("prototype")
@Entity
public class Book {
	
	@jakarta.persistence.Id
	private String Id;
	private String name;
	private String author;
	private String cost;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Library [Id=" + Id + ", name=" + name + ", author=" + author + ", cost=" + cost + "]";
	}
	
}
