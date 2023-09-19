package com.jeanlucas.bookservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeanlucas.bookservice.entities.Book;
import com.jeanlucas.bookservice.repositories.BookRepository;

@RestController
@RequestMapping(value = "book-service")
public class BookController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository repository;
	
	@GetMapping(value = "/{id}/{currency}")
	public Book findBook (@PathVariable Long id, @PathVariable String currency){
		var book = repository.findById(id).get();
		if(book == null) throw new RuntimeException("Book not found");
		
		var port = environment.getProperty("local.server.port");
		book.setEnvironment(port);
		
		return book;
		
	}
}
