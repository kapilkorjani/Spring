package com.java.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class SessionSingleton {


	@Autowired
	static
	SessionFactory sessionFactory;
	
	private static Session sess;
	private SessionSingleton() {}
	public static Session getSession()
	{
		if(sess==null)
		{
			sess = sessionFactory.openSession();
	        return sess;
		}
		else
		{
			return sess;
		}
	}
}
