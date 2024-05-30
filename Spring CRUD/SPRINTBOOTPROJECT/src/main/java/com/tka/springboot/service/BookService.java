package com.tka.springboot.service;

import java.util.List;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.springboot.controller.Stirng;
import com.tka.springboot.dao.BookDao;
import com.tka.springboot.entity.Book;

@Service
public class BookService {

	@Autowired
	BookDao dao;
	
	
	public String addBook( Book book) {
		
		
		return dao.addBook(book); 
		
	}


	public String deleteBook(long id) {
		return dao.deleteBook(id);
	}


	public String updateBook(long id,Book book) {

		return dao.updateBook(id, book);
	}


	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}


	public Book getbyId(long id) {
		return dao.getbyId(id);
	}


	public List<Book> getByName(String name) {
		
		return dao.getByName(name);
	}


	public String getByAuthorName(String author) {
		
		return dao.getByAuthorName(author);
	}


	public Object getByMaxPrice(double price) {
		
		return dao.getByMaxPrice(price);
	}


	public Object getByMinPrice(double price) {
		
		return dao.getByMinPrice(price);
	}

}
