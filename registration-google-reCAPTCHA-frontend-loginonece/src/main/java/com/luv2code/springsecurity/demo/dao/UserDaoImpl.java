package com.luv2code.springsecurity.demo.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public User findByUserName(String theUserName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		System.out.println("222222222222");
		System.out.println("thesession:	"+currentSession);

		// now retrieve/read from database using username
		Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", theUserName);
		
		System.out.println("thequery:	"+theQuery);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
			System.out.println("theuser:	"+theUser);
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public void save(User theUser) {
		// get current hibernate session
		System.out.println("3333333333");
		Session currentSession = entityManager.unwrap(Session.class);
		System.out.println("thenewsession:	"+currentSession);
		System.out.println("thenewuser:	"+theUser);
		
		// create the user ... finally LOL
		currentSession.saveOrUpdate(theUser);
	}

}
