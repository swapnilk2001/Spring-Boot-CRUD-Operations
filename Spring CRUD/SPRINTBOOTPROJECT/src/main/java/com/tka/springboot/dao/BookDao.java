package com.tka.springboot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.springboot.entity.Book;
import com.tka.springboot.service.Stirng;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class BookDao {

	@Autowired
	SessionFactory sf;

	public String addBook(Book book) {
		String msg;
		try {
			Session session = sf.openSession();
			Book book1 = session.get(Book.class, book.getId());
			if (book1 == null) {
				session.save(book);
				session.beginTransaction().commit();
				msg = "Book added successfully";
			} else {
				msg = "Book already exist";
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong";
		}

		return msg;

	}

	public String deleteBook(long id) {

		String msg;
		try {

			Session session = sf.openSession();
			Book book = session.get(Book.class, id);
			if (book != null) {
				session.delete(book);
				session.beginTransaction().commit();
				msg = "deleted successfully";
			} else {
				msg = "Book not exist";
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg = "something went wrong";
		}

		return msg;
	}

	public String updateBook(long id,Book book) {
		String msg;
		try {
			Session session = sf.openSession();
			Book dbbook = session.get(Book.class, id);
			if (dbbook != null) {
				dbbook.setAuthor(book.getAuthor());
				dbbook.setName(book.getName());
				dbbook.setPrice(book.getPrice());
				
				session.update(dbbook);
				session.beginTransaction().commit();
				msg = "Updated record successfully";
			} else {
				msg = "Book not Exist to Update";
			}

		} catch (Exception e) {
			msg = "something went wrong" + e.getMessage();
		}

		return msg;
	}

//	public List<Book> getAllBooks() {
//		List<Book>book=null;
//		String msg;
//
//		try {
//			Session session = sf.openSession();
//			Query<Book> query = session.createQuery("FROM Book", Book.class);
//			//List<Book>books=query.list();
//			msg="fetching all record successfully";
//
//			return query.list();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			msg = "something went wrong" + e.getMessage();
//
//		}
//
//		return book;
//	}
	
	
	public List<Book>getAllBooks(){
		Session session=sf.openSession();
		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<Book>cq=cb.createQuery(Book.class);
		Root<Book>root=cq.from(Book.class);
		cq.select(root);
		Query<Book>query=session.createQuery(cq);
		List<Book>list=query.list();
		list.forEach(b->{System.out.println(b);});
		return list;
		
		
	}

	public Book getbyId(long id) {
		Session session =sf.openSession();
		return session.get(Book.class, id);
	}

	public List<Book> getByName(String name) {
		
		Session session=sf.openSession();
		Query<Book>book1=session.createQuery("SELECT b FROM Book b WHERE b.name=:BookName",Book.class);
		book1.setParameter("BookName", name);
		List<Book>book=book1.list();
		
		return book;
	}

	public String getByAuthorName(String author) {
		
		
		Session session=sf.openSession();
		Query<Book>author1=session.createQuery("SElECT a FROM Book a WHERE a.author=:authorName",Book.class);
		author1.setParameter("authorName", author);
		return author;
	}

	public Object getByMaxPrice(double price) {
	
			Session session=sf.openSession();
		Query<Book>bk=session.createQuery("SELECT b FROM Book b WHERE b.price>=:Bookprice",Book.class);
			bk.setParameter("Bookprice", price);
			
		bk.stream().forEach(e->{System.out.println(e);});
		return price;
	}

	public Object getByMinPrice(double price) {
		Session session=sf.openSession();
		Query<Book>bk=session.createQuery("SELECT b FROM Book b WHERE b.price<=:BookName",Book.class);
		bk.setParameter("BookName", price);
		bk.stream().forEach(e->{System.out.println(e);});
	return price;
	}

}
