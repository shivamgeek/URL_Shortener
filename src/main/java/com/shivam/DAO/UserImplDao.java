package com.shivam.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shivam.Entity.URL;
import com.shivam.Entity.User;

@Repository
public class UserImplDao implements UserDao {

	@Autowired
	SessionFactory mySessionFactory;
	
	public void saveUser(User u) {
		Session session = mySessionFactory.getCurrentSession();
		session.saveOrUpdate(u);
	}

	public void deleteUser(int id) {
		Session session = mySessionFactory.getCurrentSession();
		Query<User> q = session.createQuery("delete from User where id=:id",User.class);
		q.setParameter("id", id);
		q.executeUpdate();

	}

	public User getUserFromId(int id) {
		Session session = mySessionFactory.getCurrentSession();
		User u = session.get(User.class, id);
		return u;
	}

	public List<User> getAllUsers() {
		Session session = mySessionFactory.getCurrentSession();
		List<User> list = session.createQuery("from User",User.class).list();
		return list;
	}

	public List<URL> getUserUrls(int id) {
		User u = getUserFromId(id);
		return u.getUrlList();
	}

}
