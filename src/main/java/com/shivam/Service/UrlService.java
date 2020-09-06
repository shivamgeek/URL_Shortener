package com.shivam.Service;

import java.util.List;

import com.shivam.Entity.URL;

public interface UrlService {
	
	public void saveUrl(URL u);
	
	public void removeUrl(int id);
	
	public URL getUrlFromId(int id);
	
	public List<URL> getAllUrls();
	
}
