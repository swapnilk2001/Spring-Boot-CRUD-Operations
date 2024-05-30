

package com.tka.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.springboot.entity.Product;
import com.tka.springboot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@PostMapping("/add")
	public String addProduct(@RequestBody Product product) {

		System.out.println(product);
		
		
		return service.addProduct(product);
		
	}
	
	
	@DeleteMapping("/Delete/{pid}")
	public String deleteProduct(@PathVariable long pid) {
		return service.deleteProduct(pid);
	}
	
	
	
	@PutMapping("/update-product/{id}")
	public String updateProduct(@PathVariable long id,@RequestBody Product product) {
		
		return service.updateProduct(id, product);
	}
	
	@GetMapping("/getAll-product")
	public List<Product> getAllProduct() {
		return service.getAllProduct();
		
	}
	
@GetMapping("/get-product-by-id/{id}")
public Product getProductById(@PathVariable long id)
{
	return service.getProductById(id);
}

}
