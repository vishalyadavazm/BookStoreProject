package com.Book.service;

import java.util.List;

import com.Book.Entity.Book;
import com.Book.Entity.MyBook;

public interface MyBookService {

	public void save(MyBook book);
	public List<MyBook>getAllBook();
	public void deleteBook(int id);
	
}
