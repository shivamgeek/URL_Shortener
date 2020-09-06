package com.shivam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shivam.DAO.UserDao;
import com.shivam.Entity.URL;
import com.shivam.Entity.User;

@Service
public class UserImplService implements UserService {

	@Autowired
	UserDao userDao;
	
	@Transactional
	public void saveUser(User u) {
		userDao.saveUser(u);
	}
	
	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	@Transactional
	public User getUserFromId(int id) {
		return userDao.getUserFromId(id);
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Transactional
	public List<URL> getUserUrls(int id) {
		return userDao.getUserUrls(id);
	}

}
