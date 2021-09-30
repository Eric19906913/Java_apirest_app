package com.Apirest.Service;

import java.util.List;

import com.Apirest.Entity.Product;

public interface ProductService {
	public List<Product> getAll();
	public Product saveProduct(Product product);
}
