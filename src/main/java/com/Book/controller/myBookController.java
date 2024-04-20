package com.Book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Book.service.MyBookService;

@Controller
public class myBookController {
	@Autowired
	MyBookService myBookService;
	
	@RequestMapping("/delete_book/{id}")
	public String deleteBook(@PathVariable int id)
	{
		myBookService.deleteBook(id);
		return "redirect:/my_book";
	}
	
	

}
