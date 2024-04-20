package com.Book.service;

import java.util.List;

import com.Book.Entity.Book;

public interface BookService {
	

	public void addBook(Book b);
	
	public List<Book>geallBook();
	public Book find(int id);

	public void Delete(int id);
}
