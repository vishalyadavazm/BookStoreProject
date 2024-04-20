package com.Book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Book.Entity.MyBook;
import com.Book.Repositary.MyBookRepositry;
@Service
public class MyBookServiceImpl implements MyBookService{
    
	@Autowired
	MyBookRepositry myBookRepo;
	
	@Override
	public void save(MyBook book) {
		myBookRepo.save(book);
	
	}

	@Override
	public List<MyBook> getAllBook() {
		
		return myBookRepo.findAll();
	}

	@Override
	public void deleteBook(int id) {
		myBookRepo.deleteById(id);	
	}

}
