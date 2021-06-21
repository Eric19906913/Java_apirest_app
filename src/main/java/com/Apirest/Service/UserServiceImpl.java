package com.Apirest.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Apirest.DAO.UserDAO;
import com.Apirest.Entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDao;
	
	@Override
	public List<User> getAll() {
		List<User> usersList = userDao.getAll();
		return usersList;
	}

	@Override
	public User getById(int id) {
		List<User> userList = getAll();
		for(User user : userList) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
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
		userDao.save(user);
		return null;
	}

}
