package com.shivam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shivam.DAO.UrlDao;
import com.shivam.Entity.URL;
import com.shivam.Entity.UrlSeed;

@Service
public class UrlImplService implements UrlService {
	
	@Autowired
	UrlDao urlDao;
	
	@Transactional
	public void saveUrl(URL u) {
		urlDao.saveUrl(u);
	}

	@Transactional
	public void removeUrl(int id) {
		urlDao.removeUrl(id);
	}

	@Transactional
	public URL getUrlFromId(int id) {
		return urlDao.getUrlFromId(id);
	}

	@Transactional
	public List<URL> getAllUrls() {
		return urlDao.getAllUrls();
	}

	@Transactional
	public UrlSeed getUrlSeed() {
		return urlDao.getUrlSeed();
	}

	@Transactional
	public void saveUrlSeed(UrlSeed s) {
		urlDao.saveUrlSeed(s);
	}

	public String generateNextSeed(String str) {
		char arr[] = str.toCharArray();
		
		int i=arr.length-1;
		
		for(;i>=0;i--) {
			char x = arr[i];
			if(x == 'Z') {
				continue;
			}else {
				arr[i] = (char) ((char)arr[i]+1);
				break;
			}
		}
		i++;
		for(;i<arr.length;i++) {
			arr[i] = 'A';
		}
		
		return new String(arr);
	}
	
	//Take last 3 digits of hashcode of original URL and the 3-digit hashseed and interleave them to form a unique string
	public String generateShortUrl(String seed, String url) {
		StringBuilder sb = new StringBuilder();
		int hash = Math.abs(url.hashCode());
		if(hash<1000) { hash=hash*1000; }
		hash = hash%1000;
		for(int i=0;i<3;i++) {
			sb = sb.append(hash%10);
			hash=hash/10;
			sb = sb.append(seed.charAt(i));
		}
		return sb.toString();
	}
	
}
