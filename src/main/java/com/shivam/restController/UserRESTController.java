package com.shivam.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.Entity.User;
import com.shivam.Service.UserService;

@RestController
@RequestMapping("/api_users")
public class UserRESTController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{userid}")
	public User getUser(@PathVariable("userid") int id) {
		User u = userService.getUserFromId(id);
		if(u == null) {
			throw new ErrorException("NO USER FOUND WITH ID "+id);
		}
		return u;
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User u) {
		u.setId(0);
		userService.saveUser(u);
		return u;
	}
	
	@DeleteMapping("/users/{userid}")
	public String deleteUser(@PathVariable("userid") int id) {
		User u = userService.getUserFromId(id);
		if(u == null) {
			throw new ErrorException("NO USER FOUND WITH ID "+id);
		}
		userService.deleteUser(id);
		return "User with ID "+id+" deleted";
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User u) {
		userService.saveUser(u);
		return u;
	}
	
}
