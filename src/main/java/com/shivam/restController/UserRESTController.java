package com.shivam.restController;

import java.sql.Timestamp;
import java.util.Calendar;
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

import com.shivam.Entity.URL;
import com.shivam.Entity.UrlSeed;
import com.shivam.Entity.User;
import com.shivam.Service.UrlMapper;
import com.shivam.Service.UrlService;
import com.shivam.Service.UserService;

@RestController
@RequestMapping("/api_users")
public class UserRESTController {

	@Autowired
	UserService userService;
	
	@Autowired
	UrlService urlService;
	
	@Autowired
	UrlMapper globalUrlMapping;
	
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
	
	@PostMapping("/users/{userid}")
	public URL addUserURL(@PathVariable("userid") int userId, @RequestBody URL url) {
		User user = userService.getUserFromId(userId);
		
		//ADD URL shortening logic here
		UrlSeed seed = urlService.getUrlSeed();
		String shortenedUrl = urlService.generateShortUrl(seed.getSeedValue(), url.getFullUrl());
		
		System.out.println(url.getFullUrl()+" converted and saved as "+shortenedUrl);
		
		//Update Seed value for next URL
		String next_seed =  urlService.generateNextSeed(seed.getSeedValue());
		seed.setSeedValue(next_seed);
		seed.setId(1);
		urlService.saveUrlSeed(seed);
		
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		cal.add(Calendar.YEAR, 1);
		Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
		
		url.setUser(user);
		url.setShortUrl(shortenedUrl);
		url.setExpirationDate(timestamp.toString());
		
		urlService.saveUrl(url);
		globalUrlMapping.getMyUrlMap().put(shortenedUrl, url);
		
		return url;
	}
	
}
