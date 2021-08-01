package com.Apirest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Apirest.DAO.ProductDAO;
import com.Apirest.Entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDao;
	
	@Override
	public List<Product> getAll() {
		List<Product> productList = productDao.getAll();
		return productList;
	}
	
}
