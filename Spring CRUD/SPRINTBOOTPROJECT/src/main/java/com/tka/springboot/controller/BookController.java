package com.tka.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.springboot.entity.Book;
import com.tka.springboot.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService service;

	@PostMapping("/insert")
	public String addBook(@RequestBody Book book) {
		System.out.println(book);

		return service.addBook(book);
	}

	@DeleteMapping("/delete/{id}")
	public String deteleBook(@PathVariable long id) {
		return service.deleteBook(id);
	}

	@PutMapping("/update/{id}")
	public String updateBook(@PathVariable long id, @RequestBody Book book) {

		return service.updateBook(id, book);
	}

	@GetMapping("/allbook")
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Object> getbyId(@PathVariable long id) {
		Book book = service.getbyId(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(book));
	}
	
	@GetMapping("/get-by-name-book/{name}")
	public List<Book> getByName(@PathVariable String name) {
		return service.getByName(name);
	}
	
	@GetMapping("/get-by-author-name/{name}")
	public String getByAuthorName(@PathVariable String name)
	{
		return service.getByAuthorName(name);
	}
	
	@GetMapping("/get-by-max-price/{price}")
	public Object getByMaxPrice(@PathVariable double price) {
		return service.getByMaxPrice(price);
	}
	
	@GetMapping("/get-by-min-price/{price}")
	public Object getByMinPrice(@PathVariable double price) {
		return service.getByMinPrice(price);
	}

}
