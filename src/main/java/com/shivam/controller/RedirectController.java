package com.shivam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shivam.Service.UrlMapper;
import com.shivam.restController.ErrorException;

@Controller
@RequestMapping("/url")
public class RedirectController {
	
	@Autowired
	UrlMapper globalUrlMapping;
	
	@GetMapping("/{shortUrl}")
	public String redirectShortUrl(@PathVariable("shortUrl") String shortUrl) {
		if(globalUrlMapping.getMyUrlMap().get(shortUrl) != null) {
			return "redirect:https://"+globalUrlMapping.getMyUrlMap().get(shortUrl);
		}
		throw new ErrorException("No Mapping found !!!!");
	}
	
}
