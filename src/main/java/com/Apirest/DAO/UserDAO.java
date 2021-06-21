package com.Apirest.DAO;

import java.util.List;

import com.Apirest.Entity.User;

public interface UserDAO {
	public List<User> getAll();
	public User getById(int userId);
	public int deleteUser(User user);
	public User updateUser(User user);
	public void save(User user);
}
