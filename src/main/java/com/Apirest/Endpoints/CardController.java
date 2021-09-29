package com.Apirest.Endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Apirest.Entity.Card;
import com.Apirest.Service.CardService;
import com.Apirest.Service.UserService;

@RestController
@RequestMapping("/api")
public class CardController {

	@Autowired
	CardService cardService;
	UserService userService;
	
	@PostMapping(path="/card/add", produces= {"application/json"})
	public ResponseEntity<Card> addCard(@RequestBody Card card) {
		String number = card.getNumber();
		//String description = card.getDescription();
		//int userId = userService.getById(0).getId();
		
		//if(cardService.validateCard(number)) {
			//Card newCard = cardService.saveCard(number, description, userId);
			//return new ResponseEntity<Card>(newCard, HttpStatus.OK);
		//}
		if(cardService.validateCard(number)) {
			return new ResponseEntity<Card>(HttpStatus.OK);
		}
		return new ResponseEntity<Card>(HttpStatus.FORBIDDEN);
	}
	
	@GetMapping(path="/card/{userId}", produces= {"application/json"})
	public ResponseEntity<List<Card>> getCards(@PathVariable int userId) {
		List<Card> cards = cardService.getCardsByUserId(userId);
		
		return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
	}
}
