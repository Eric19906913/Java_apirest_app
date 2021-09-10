package com.Apirest.Endpoints;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Apirest.Entity.Sell;

@RestController
@RequestMapping("/api")
public class SellController {

	@PostMapping(path="/sells", produces= {"application/json"})
	public ResponseEntity<Sell> saveUser(@RequestBody Sell sell) {
		
		
		//returns the new user and a http status code 201
		return new ResponseEntity<Sell>(sell, HttpStatus.CREATED);
	}
}
