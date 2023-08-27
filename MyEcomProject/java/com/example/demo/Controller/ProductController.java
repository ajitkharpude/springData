package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Services.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
@PostMapping({"/addNewProduct"})
public Product addNewProduct(@RequestBody Product product) {
	
return productService.addNewProduct(product);
}
}
