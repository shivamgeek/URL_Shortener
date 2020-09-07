package com.shivam.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shivam.restController.ErrorException;

@Controller
@RequestMapping("/url")
public class RedirectController {
	
	@Autowired
	HashMap<String, String> globalUrlMapping;
	
	@GetMapping("/{shortUrl}")
	public String redirectShortUrl(@PathVariable("shortUrl") String shortUrl) {
		if(globalUrlMapping.get(shortUrl) != null) {
			return "redirect:https://"+globalUrlMapping.get(shortUrl);
		}
		throw new ErrorException("No Mapping found !!!!");
	}
	
}
