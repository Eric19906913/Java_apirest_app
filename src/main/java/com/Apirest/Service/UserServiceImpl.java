package com.Apirest.Service;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Apirest.DAO.UserDAO;
import com.Apirest.Entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDao;
	//this is for encrypt passwords.
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	
	@Override
	public List<User> getAll() {
		List<User> usersList = userDao.getAll();
		return usersList;
	}

	@Override
	public User getById(int id) {
		User user = userDao.getById(id);
		if(user != null) {
			return user;
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		User user = userDao.getByEmail(email);
		return user;
	}

	@Override
	public int delete(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getByDate(Date birthday) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveUser(User user) {
		//this service is gonna have more logic, like verify for an existing user and so.
		//TODO ..
		
		String encryptPassword = bcrypt.encode(user.getPassword());
		user.setPassword(encryptPassword);
		
		userDao.save(user);
		
		return user;
	}
	
	@Override
	public boolean canLogin(String password, User loginUser) {
		//this is for verify if the password matchs
		boolean passwordVerify = bcrypt.matches(password, loginUser.getPassword()); 
		
		return passwordVerify;
	}

}
