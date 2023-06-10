package com.SpringBoot.SpringBoot;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookContoller {
	@RestController
	public class BookController {

	    private List<Book> books = new ArrayList<>();

	    // Get all books
	    @GetMapping("/books")
	    public List<Book> getAllBooks() {
	        return books;
	    }

	    // Get a book by ID
	    @GetMapping("/books/{id}")
	    public ResponseEntity<Book> getBookById(@PathVariable int id) {
	        Optional<Book> optionalBook = books.stream().filter(book -> book.getId() == id).findFirst();
	        return optionalBook.map(book -> ResponseEntity.ok().body(book))
	                .orElse(ResponseEntity.notFound().build());
	    }

	    // Create a new book
	    @PostMapping("/book")
	    public ResponseEntity<Book> createBook(@RequestBody Book book) {
	        books.add(book);
	        return ResponseEntity.status(HttpStatus.CREATED).body(book);
	    }

	    // Update an existing book
	    @PutMapping("/books/{id}")
	    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
	        Optional<Book> optionalBook = books.stream().filter(book -> book.getId() == id).findFirst();
	        if (optionalBook.isPresent()) {
	            Book book = optionalBook.get();
	            book.setName(updatedBook.getName());
	            book.setAuthor(updatedBook.getAuthor());
	            return ResponseEntity.ok().body(book);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Delete a book
	    @DeleteMapping("/books/{id}")
	    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
	        boolean removed = books.removeIf(book -> book.getId() == id);
	        if (removed) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}

}
