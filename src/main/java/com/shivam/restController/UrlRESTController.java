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

import com.shivam.Entity.URL;
import com.shivam.Service.UrlService;

@RestController
@RequestMapping("/url_api")
public class UrlRESTController {

	@Autowired
	UrlService urlService;
	
	@GetMapping("/urls")
	public List<URL> getAllUrls(){
		return urlService.getAllUrls();
	}
	
	@GetMapping("/urls/{urlid}")
	public URL getUrl(@PathVariable("urlid") int id) {
		URL u = urlService.getUrlFromId(id);
		if(u == null) {
			throw new ErrorException("NO URL FOUND WITH ID "+id);
		}
		return u;
	}
	
	@PostMapping("/urls")
	public URL addUrl(@RequestBody URL u) {
		u.setId(0);
		urlService.saveUrl(u);
		return u;
	}
	
	@DeleteMapping("/urls/{urlid}")
	public String deleteUrl(@PathVariable("urlid") int id) {
		URL u = urlService.getUrlFromId(id);
		if(u == null) {
			throw new ErrorException("NO URL FOUND WITH ID "+id);
		}
		urlService.removeUrl(id);
		return "URL with ID "+id+" deleted";
	}
	
	@PutMapping("/urls")
	public URL updateUrl(@RequestBody URL u) {
		urlService.saveUrl(u);
		return u;
	}
	
}
