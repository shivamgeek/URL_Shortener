package com.shivam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shivam.DAO.UrlDao;
import com.shivam.Entity.URL;

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

}
