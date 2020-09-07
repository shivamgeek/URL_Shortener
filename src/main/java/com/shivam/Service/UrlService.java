package com.shivam.Service;

import java.util.List;

import com.shivam.Entity.URL;
import com.shivam.Entity.UrlSeed;

public interface UrlService {
	
	public void saveUrl(URL u);
	
	public void removeUrl(int id);
	
	public URL getUrlFromId(int id);
	
	public List<URL> getAllUrls();
	
	public UrlSeed getUrlSeed();
	
	public void saveUrlSeed(UrlSeed s);
	
	public String generateNextSeed(String str);
	
}
