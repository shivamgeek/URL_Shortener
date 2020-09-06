package com.shivam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shivam.Entity.User;
import com.shivam.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/goHome")
	public String goHome() {
		return "homepage";
	}
	
	@GetMapping("/register")
	public String registerUser(Model model) {
		User u = new User();
		model.addAttribute("userData", u);
		return "register-user";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomerData(@ModelAttribute("userData") User user) {
		userService.saveUser(user);
		return "homepage";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = userService.doLogin(email, password);
		if(user == null) {
			return "redirect:/user/goHome";
		}else {
			return "user_homepage";
		}
	}
	
}
