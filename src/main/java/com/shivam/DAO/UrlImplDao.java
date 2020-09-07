package com.shivam.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shivam.Entity.URL;
import com.shivam.Entity.UrlSeed;

@Repository
public class UrlImplDao implements UrlDao {

	@Autowired
	SessionFactory mySessionFactory;
	
	public void saveUrl(URL u) {
		Session session = mySessionFactory.getCurrentSession();
		session.saveOrUpdate(u);
	}

	public void removeUrl(int id) {
		Session session = mySessionFactory.getCurrentSession();
		Query<URL> q = session.createQuery("delete from URL where id=:id");
		q.setParameter("id", id);
		q.executeUpdate();
	}

	public URL getUrlFromId(int id) {
		Session session = mySessionFactory.getCurrentSession();
		URL u = session.get(URL.class, id);
		return u;
	}

	public List<URL> getAllUrls() {
		Session session = mySessionFactory.getCurrentSession();
		List<URL> list = session.createQuery("from URL",URL.class).list();
		return list;
	}

	public UrlSeed getUrlSeed() {
		Session session = mySessionFactory.getCurrentSession();
		List<UrlSeed> seeds = session.createQuery("from UrlSeed",UrlSeed.class).list();
		return seeds.get(0);
	}

	public void saveUrlSeed(UrlSeed s) {
		Session session = mySessionFactory.getCurrentSession();
		session.saveOrUpdate(s);
	}
}
