package com.SpringBoot.SpringBoot;

public class Book {
	long id;
	String name;
	String author;
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	public Book(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	
	
}
