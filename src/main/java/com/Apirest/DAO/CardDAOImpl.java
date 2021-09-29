package com.Apirest.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Apirest.Entity.Card;
import com.Apirest.Entity.User;

@Repository
public class CardDAOImpl implements CardDAO{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Card addNewCard(User user, Card card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> getCardsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
