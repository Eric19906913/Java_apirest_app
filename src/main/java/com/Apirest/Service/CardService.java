package com.Apirest.Service;

import java.util.List;

import com.Apirest.Entity.Card;

public interface CardService {
	public boolean validateCard(String number);
	public Card saveCard(String number, String description, int userId);
	public List<Card> getCardsByUserId(int userId);
}
