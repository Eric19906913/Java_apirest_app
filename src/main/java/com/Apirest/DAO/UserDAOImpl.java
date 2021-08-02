package com.Apirest.DAO;

import java.sql.PreparedStatement;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.loader.plan.exec.query.internal.SelectStatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Apirest.Entity.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<User> getAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		TypedQuery<User> query = currentSession.createQuery("from User", User.class);
		
		List<User> usersList = query.getResultList();
		return usersList;
	}

	@Override
	public User getById(int userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		User user =  currentSession.get(User.class, userId);
		
		return user;
	}

	@Override
	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void save(User user) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		String query = "INSERT INTO users (name, email, phone, password, user_name) VALUES(?, ?, ?, ?, ?)";

			currentSession.createNativeQuery(query)
				.setParameter(1, user.getName())
				.setParameter(2, user.getEmail())
				.setParameter(3, user.getPhone())
				.setParameter(4, user.getPassword())
				.setParameter(5, user.getUsername())
				.executeUpdate();
	}
	@Override
	public User getByEmail(String email) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		String query = "SELECT * FROM users WHERE email=?";
		
		var result = currentSession.createNativeQuery(query)
			.setParameter(1, email).getQueryReturns();
		
		System.out.println(result);
		return (User)result;
	}

}
