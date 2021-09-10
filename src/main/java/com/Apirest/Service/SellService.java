package com.Apirest.Service;

import java.util.List;

import com.Apirest.Entity.Product;
import com.Apirest.Entity.Sell;
import com.Apirest.Entity.User;

public interface SellService {
	public Sell makeSell(List<Product> products, User user);
	public List<Sell> showSellsByUser(User user);
	public List<Sell> showMostSelled();
	public List<Sell> lastSells();
	public List<Sell> getByType(String type);
}
