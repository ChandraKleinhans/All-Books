package com.codingdojo.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.booksapi.models.Book;
import com.codingdojo.booksapi.repositories.BookRepository;

@Service
public class BookService {
	//adding bookRepository as dependency
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	
	// finds and returns all books
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
    
 // creates a book
    public Book create(Book book) {
        return bookRepository.save(book);
    }
    
    
	// retrieves a book
    public Book getOne(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //edits/updates book
    public Book updateOne(Long id, String title, String description, String language, Integer pages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			Book book = this.getOne(id);
			book.setTitle(title);
			book.setDescription(description);
			book.setLanguage(language);
			book.setNumberOfPages(pages);
			return this.bookRepository.save(book);
		}	else {
			return null;
		}
	}
	public void deleteOne(Long id) {
		bookRepository.deleteById(id);
		
	}
	
	// delete book by id
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
