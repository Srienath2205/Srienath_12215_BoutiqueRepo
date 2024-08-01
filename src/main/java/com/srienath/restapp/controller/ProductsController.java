package com.srienath.restapp.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srienath.restapp.model.Products;
import com.srienath.restapp.serviceimpl.ProductsServiceImpl;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:3000")
public class ProductsController {
	
	ProductsServiceImpl service;
	
	String success="Success";
	String failure="Failure";
	
	public ProductsController(ProductsServiceImpl service) {
		super();
		this.service = service;
	}

	@PostMapping
	public String insertProducts(@RequestBody Products petshop)
	{
		String msg="";
		try {
			service.addProduct(petshop);
			msg=success;
		} 
		
		catch(Exception e) {
			e.printStackTrace();
			msg=failure;
		}
		return msg;
	}
	
	@GetMapping("{id}")
	public Products getProductById(@PathVariable("id") int id) {
		return service.getProduct(id);
	}
	
	@GetMapping("/all")
	public List<Products> getAllProducts() {
		return service.getAllProducts();
	}
	
	@PutMapping
	public String doUpdate(@RequestBody Products products)
	{
		String msg="";
		try {
			service.updateProduct(products);
			msg=success;
		} 
		
		catch(Exception e) {
			e.printStackTrace();
			msg=failure;
		}
		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deleteProductById(@PathVariable("id") int id) {
		String msg="";
		try {
			service.deleteProduct(id);
			msg=success;
		} 
		
		catch(Exception e) {
			e.printStackTrace();
			msg=failure;
		}
		return msg;
	}
	
}
