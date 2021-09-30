package com.Apirest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Apirest.Entity.Product;
import com.Apirest.Entity.User;

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

	@Override
	@Transactional
	public void saveProduct(Product product) {
		Session currentSession = entityManager.unwrap(Session.class);
		String query = "INSERT INTO products (description, discharge_date, name, price, stock) VALUES(?, ?, ?, ?, ?)";
		
		
			currentSession.createNativeQuery(query)
				.setParameter(1, product.getDescription())
				.setParameter(2, product.getDischargeDate())
				.setParameter(3, product.getName())
				.setParameter(4, product.getPrice())
				.setParameter(5, product.getStock())
				.executeUpdate();
	}

}
