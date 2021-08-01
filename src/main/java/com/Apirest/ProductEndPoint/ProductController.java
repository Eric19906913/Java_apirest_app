package com.Apirest.ProductEndPoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Apirest.Entity.Product;
import com.Apirest.Service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(path="/products", produces= {"application/json"})
	public List<Product> getAll() {
		List<Product> productList = productService.getAll();
		if(productList == null) {
			return null;
		}
		return productList;
	}
}
