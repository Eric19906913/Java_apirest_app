package com.Apirest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Apirest.Entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Product> getAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		TypedQuery<Product> query = currentSession.createQuery("from Product", Product.class);
		
		List<Product> productList = query.getResultList();
		return productList;
	}

}
