package com.Book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Book.Entity.Book;
import com.Book.Entity.MyBook;
import com.Book.service.BookService;
import com.Book.service.MyBookService;

@Controller
public class Mycontroller {

	@Autowired
	BookService BookSer;
	@Autowired
	MyBookService myBookService;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookregister()
	{
		return "bookRegister";
	}
	
	@GetMapping("/available_book")
	public ModelAndView getAllBook()
	{
	List<Book>list=BookSer.geallBook();
		
		return new ModelAndView("Booklist","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b)
	{
		BookSer.addBook(b);
		
		return "redirect:/available_book";
	}
	
	@GetMapping("/my_book")
	public String myBook(Model model)
	{
		List<MyBook>list=myBookService.getAllBook();
		model.addAttribute("book", list);
		return "myBook";
	}
	
	@RequestMapping("/my_book/{id}")
	public String myBookList(@PathVariable("id") int id)
	{
		Book b= BookSer.find(id);
		MyBook mb=new MyBook(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.save(mb);
		System.out.println("success");
		return "redirect:/my_book";
	}
	
	@RequestMapping("/delete_bookList/{id}")
	public String deleteBook(@PathVariable("id") int id)
	{
		BookSer.Delete(id);
		return "redirect:/available_book";
	}
	
	@RequestMapping("/update_book/{id}")
	public String update(@PathVariable("id") int id, Model model)
	{
		Book b=BookSer.find(id);
		model.addAttribute("book", b);
		return "EditBook";
	}
}
