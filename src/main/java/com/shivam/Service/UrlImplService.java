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
	
}
