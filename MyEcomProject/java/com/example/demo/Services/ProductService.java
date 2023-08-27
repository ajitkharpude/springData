package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Dao.ProductDao;
import com.example.demo.Entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	public Product addNewProduct(@RequestBody Product product) {
		
return productDao.save(product);
	}
}
