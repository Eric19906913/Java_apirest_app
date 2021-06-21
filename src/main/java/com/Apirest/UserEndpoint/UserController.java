package com.Apirest.UserEndpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<User> getAll(){
		List<User> usersList = userService.getAll();
		if(usersList == null) {
			return null;
		}
		return usersList;
	}
	
	@GetMapping(path="/users/{userId}", produces= {"application/json"})
	public User getbyId(@PathVariable int userId) {
		User user = userService.getById(userId);
		if(user == null) {
			throw new RuntimeException("User not found");
		}
		return user;
	}
	
	@PostMapping(path="/users", produces= {"application/json"})
	public User saveUser(@RequestBody User user) {
		user.setId(0);
		
		userService.saveUser(user);
		
		return user;
	}
	
	@PostMapping(path="/users/login", produces= {"application/json"})
	public boolean login(@RequestBody User user) {
		String password = user.getPassword();
		String email = user.getEmail();
		
		User loginUser = userService.getByEmail(email);
		
		if(loginUser == null) {
			return false;
		}
		
		boolean canLogin = userService.canLogin(password , loginUser);
		
		return canLogin;
	}
}
