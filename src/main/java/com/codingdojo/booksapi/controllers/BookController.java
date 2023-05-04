package com.codingdojo.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.booksapi.models.Book;
import com.codingdojo.booksapi.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookServ;
	
	@RequestMapping("/books")
	public String allbooks(Model model) {
		List<Book> books = bookServ.getAll();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
	@RequestMapping("/books/{bookId}")
	public String index(@PathVariable("bookId") Long bookId, Model model){
		System.out.println(bookId);
		Book book = bookServ.getOne(bookId);
		System.out.println(book);
		
		model.addAttribute("book", book);
		
		return "show.jsp";
	}


}
