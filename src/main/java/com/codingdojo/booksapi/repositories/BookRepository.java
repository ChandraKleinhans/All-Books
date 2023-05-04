package com.codingdojo.booksapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.booksapi.models.Book;

@Repository
public interface BookRepository extends CrudRepository <Book, Long> {
	// retrieves all books from database
    List<Book> findAll();
    // finds books with descriptions containing search string
    List<Book> findByDescriptionContaining(String search);
    // counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);

}
