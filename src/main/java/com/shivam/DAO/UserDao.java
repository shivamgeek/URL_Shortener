package com.shivam.DAO;

import java.util.List;

import com.shivam.Entity.URL;
import com.shivam.Entity.User;

public interface UserDao {
	
	public void saveUser(User u);
	
	public void deleteUser(int id);
	
	public User getUserFromId(int id);
	
	public List<User> getAllUsers();

	public List<URL> getUserUrls(int id);
	
	public List<User> doLogin(String email, String password);
	
}
