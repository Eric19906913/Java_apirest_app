package com.Apirest.DAO;

import java.util.Date;
import java.util.List;

import com.Apirest.Entity.Product;
import com.Apirest.Entity.Sell;
import com.Apirest.Entity.User;

public interface SellDAO {
	public List<Sell> getByUser(User user);
	public List<Sell> getByQuantity(String orderBy);
	public Sell makeSell(List<Product> products, User user);
	public List<Sell> getByDate(Date date);
	public List<Sell> getByProduct(Product product);
}
