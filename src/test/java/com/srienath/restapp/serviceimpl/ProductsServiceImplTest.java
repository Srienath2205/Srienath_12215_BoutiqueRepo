package com.srienath.restapp.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.srienath.restapp.model.Products;

@SpringBootTest
class ProductsServiceImplTest {

	@Autowired
	ProductsServiceImpl productsServiceImpl;
	
	@Test
	void testAddProduct() {
		Products obj= new Products(4, "Collar", "Accessory", 6, 799, null);
		assertEquals("Success",productsServiceImpl.addProduct(obj));			
	}

	@Test
	void testGetAllProducts() {
		assertNotNull(productsServiceImpl.getAllProducts());
	}

	@Test
	void testUpdateProduct() {
		Products obj=new Products(3, "Collar", "Accessory", 6, 799, null);
		assertEquals("Success",productsServiceImpl.updateProduct(obj));	
	}
	
	@Test
	void testDeleteProduct() {
		assertEquals("Deleted", productsServiceImpl.deleteProduct(3));
	}
	
	@Test
	void testGetProduct() {
		Products products = new Products();
		products = productsServiceImpl.getProduct(12);
		assertNotNull(products);
	}
}
