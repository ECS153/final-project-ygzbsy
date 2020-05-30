package com.luv2code.springsecurity.demo.dao;

import javax.persistence.EntityManager;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Attempts;

@Repository
public class AttemptDaoImpl implements AttemptDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Attempts theAttempt){
		// TODO Auto-generated method stub

		//System.out.println("thenewsession0:	"+currentSession);
		System.out.println("thenewattemot:	"+theAttempt);
		
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//System.out.println("thenewsession0:	"+currentSession);
		System.out.println("thenewattemot:	"+theAttempt);
		
		// create the user ... finally LOL
		currentSession.saveOrUpdate(theAttempt);
	}

}
