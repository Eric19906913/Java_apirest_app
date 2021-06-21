package com.Apirest.Service;

import java.util.Date;
import java.util.List;

import com.Apirest.Entity.User;

public interface UserService {
	public List<User> getAll();
	public User getById(int id);
	public User getByEmail(String email);
	public int delete(User user);
	public int update(User user);
	public User getByDate(Date birthday);
	public User saveUser(User user);
	public boolean canLogin(String password, User loginUser);
}
