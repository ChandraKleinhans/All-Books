package com.codingdojo.booksapi.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.booksapi.models.Book;
import com.codingdojo.booksapi.services.BookService;

@RestController
@RequestMapping("/api")
public class ApiController {

		
		public final BookService bookServ;

		public ApiController(BookService bookServ) {
			this.bookServ = bookServ;
		}

		//Get One
		@GetMapping("/books/{id}")
		public Book getOne(@PathVariable("id") Long id) {
			return bookServ.getOne(id);
		}
		
	
		//Get All
		@GetMapping("/books")
		public List<Book> index() {
        return bookServ.getAll();
		}
		
		
		//Create
		@RequestMapping(value = "/books", method = RequestMethod.POST)
		public Book createOne(@RequestParam("title")String title,
										@RequestParam("description")String description,
										@RequestParam("language") String language,
										@RequestParam("numberOfPages") Integer pages) {
			Book newBook = new Book(title, description, language, pages);
			
			
			return bookServ.create(newBook);
		}
		
		//Update
		@RequestMapping("/api/books/{id}")
	    public Book show(@PathVariable("id") Long id) 
		{
	        Book book = bookServ.getOne(id);
	        return book;
	    }
		@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	    public Book update(
	    		@PathVariable("id") Long id, 
	    		@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String description, 
	    		@RequestParam(value="language") String language,
	    		@RequestParam(value="pages") Integer pages) {
	    		Book book = bookServ.updateOne(id, title, description, language, pages);
	        return book;
	    }
		
		//Delete
		@RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
	    public void destroy(@PathVariable("id") Long id) {
	        bookServ.deleteOne(id);
	    }
}
