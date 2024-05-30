package com.tka.springboot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tka.springboot.entity.Product;

@Repository
public class ProductDao {
	
	@Autowired
	SessionFactory sf;
	
	public String addProduct(Product product) {
		String msg;
		try {
			Session session=sf.openSession();
			Product product2=session.get(Product.class, product.getPid());
			if(product2== null) {
			
			
				session.save(product);
				session.beginTransaction().commit();
				msg="added";
				
			}
			else
			{
				msg="Product already exist";
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			msg="something is wrong";
			
		}
		
		return msg;
		
	}

	public String deleteProduct(long pid) {
		String msg;
		try {
			
			Session session = sf.openSession();
			Product product=session.get(Product.class, pid);
			if(product!=null) {
				session.delete(product);
				session.beginTransaction().commit();
				msg="Deleted product successfully";
			}
			else {
				msg="Product not exist to delete";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg="something went wrong"+e.getMessage();
		}
		return msg;
	}

	public String updateProduct(long pid,Product product) {
		String msg;
		try {
			Session session=sf.openSession();
			Product dbproduct=session.get(Product.class, pid);
			if(dbproduct!=null) {
				dbproduct.setName(product.getName());
				dbproduct.setPrice(product.getPrice());
				dbproduct.setQty(product.getQty());
				session.update(dbproduct);
				session.beginTransaction().commit();
				msg="Product updated successfully";
			}
			else {
				msg="Product not exist";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg="Something went wrong"+e.getMessage();
		}
		return msg;
	}

	public List<Product> getAllProduct() {
		List<Product>product=null;
		String msg;
		
		try {
			Session session=sf.openSession();
			Query<Product>query=session.createQuery("FROM Product",Product.class);
			product=query.list();
			query.stream().forEach(e->{System.out.println(e);});
			msg="Fetching dada successfully";
				
			}
		
			
		 catch (Exception e) {
			e.printStackTrace();
			msg="Something went wrong"+e.getMessage();
		}
		
		
		
		return product;
	}

	public Product getProductById(long pid) {
	Session session=sf.openSession();
	Product product=session.get(Product.class, pid);
		
		return product;
	}

}
