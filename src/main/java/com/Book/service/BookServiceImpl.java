package com.Book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Book.Entity.Book;
import com.Book.Repositary.BookRepositry;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepositry BookRepo;
	
	@Override
	public void addBook(Book b) {
		BookRepo.save(b);
		
	}

	@Override
	public List<Book> geallBook() {
		
		return BookRepo.findAll();
	}

	@Override
	public Book find(int id) {
		
		return BookRepo.findById(id).get();
	}

	@Override
	public void Delete(int id) {
		BookRepo.deleteById(id);	
	}

}
