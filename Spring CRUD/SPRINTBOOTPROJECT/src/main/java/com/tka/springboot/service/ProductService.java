package com.tka.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.springboot.dao.ProductDao;
import com.tka.springboot.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductDao dao;
	
	public String addProduct(Product product) {
		
		
		
		return dao.addProduct(product);
		
	}

	public String deleteProduct(long pid) {

		return dao.deleteProduct(pid);
	}

	public String updateProduct(long pid,Product product) {
		
		return dao.updateProduct(pid, product);
	}

	public List<Product> getAllProduct() {
		return dao.getAllProduct();
	}

	public Product getProductById(long pid) {

		
		return dao.getProductById(pid);
	}

}
