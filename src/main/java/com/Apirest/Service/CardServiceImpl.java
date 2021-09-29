package com.Apirest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Apirest.DAO.CardDAO;
import com.Apirest.DAO.UserDAO;
import com.Apirest.Entity.Card;
import com.Apirest.Entity.User;

@Service
public class CardServiceImpl implements CardService{

	@Autowired
	CardDAO cardDao;
	UserDAO userDao;
	
	//Validate if the number of the card is valid.
	private boolean testCard(String cardNumber){
		double sum = 0;
		int digit = 0;
		
		for(int i = 0; i < cardNumber.length(); i++) {
			digit = Integer.parseInt(String.valueOf(cardNumber.charAt(i)));
			if(i % 2 == 0) {
				digit *= 2;
				
				if(digit >= 10) {
					digit -= 9;
				}
			}
			sum += digit;
		}
		
		return sum % 10 == 0;
	}
	
	@Override
	public boolean validateCard(String number) {
		String type = "";
		/*if(!number.isEmpty() && number.length() >= 13) {
			int firstDigit = Integer.parseInt(number.substring(0, 1));
			switch(firstDigit){
				case 4: type = "Visa";
					break;
				case 5: type = "Master Card";
					break;
				default: type = "Uala / Others";
			}
			return true;
		}*/
		return this.testCard(number);
	}

	@Override
	public Card saveCard(String number, String description, int userId) {
		Card card = new Card(number, description);
		//search for the user here to create a new card that belongs to him.
		User user = userDao.getById(userId);
		Card newCard = cardDao.addNewCard(user, card);
		return newCard;
	}

	@Override
	public List<Card> getCardsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	/*
	 * function CheckLuhn(purportedCC: String): Boolean;
	var
  	i: Integer;
  	Sum: Integer;
  	Digit: Integer;
	begin
  		Sum := 0;
  		i := Length( purportedCC )
  		
  		for i downto 1 do begin
    		
    		Digit := Ord( purportedCC[ i ] ) - Ord( '0' );
			
			if not(Odd( i )) then begin
	  			
	  			Digit := Digit * 2;
	  			
	  			if (Digit > 9) then Digit := Digit - 9;
        	end;
    		
    		Inc( Sum, Digit );
  		end;
  		
  		Result := Sum mod 10 = 0;
	end;
	 * 
	 * 
	 * 
	 * 
	 * */

}
