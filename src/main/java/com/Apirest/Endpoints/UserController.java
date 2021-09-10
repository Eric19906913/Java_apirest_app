package com.Apirest.Endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Apirest.Entity.User;
import com.Apirest.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path="/users", produces= {"application/json"})
	public ResponseEntity<List<User>> getAll(){
		List<User> usersList = userService.getAll();
		if(usersList == null) {
			//return a status code 403.
			return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);
		}
		//returns a status code 200 and a list of users
		return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
	}
	
	@GetMapping(path="/users/{userId}", produces= {"application/json"})
	public ResponseEntity<User> getbyId(@PathVariable int userId) {
		User user = userService.getById(userId);
		if(user == null) {
			//returns a bad request if the user doesnt exists
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		//returns the given user and a 200 status code
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping(path="/users", produces= {"application/json"})
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		user.setId(0);
		
		var result = userService.saveUser(user);
		
		System.out.println("value of result: "+ result);
		
		//returns the new user and a http status code 201
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@DeleteMapping(path="/users/{userId}", produces={"application/json"})
	public ResponseEntity<User> deleteById(@PathVariable int userId) {
		User user = userService.getById(userId);
		//TODO change this to move logic to service
		if (user == null) {
			//returns a bad request if the user does not exists
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			userService.delete(user);
		}catch(Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		//returns the deleted user and 200 status.
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
	
	@PostMapping(path="/users/login", produces= {"application/json"})
	public ResponseEntity<User> login(@RequestBody User user) {
		String password = user.getPassword();
		String email = user.getEmail();
		
		User loginUser = userService.getByEmail(email);
		System.out.println(loginUser);
		//TODO change this for a try..catch block and move logic to service
		//returns status 443 if the user does not exists or cant login.
		if(loginUser == null) {
			return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
		}
		
		boolean canLogin = userService.canLogin(password , loginUser);
		
		if(!canLogin) {
			return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
		}
		//return status 200 if user can login.
		return new ResponseEntity<User>(HttpStatus.OK);
	}
}
