package com.Apirest.DAO;

import java.util.List;

import com.Apirest.Entity.Card;
import com.Apirest.Entity.User;

public interface CardDAO {
	public Card addNewCard(User user, Card card);
	public List<Card> getCardsByUserId(int userId);
}
