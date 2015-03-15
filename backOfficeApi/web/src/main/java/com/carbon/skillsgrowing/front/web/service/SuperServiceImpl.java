package com.carbon.skillsgrowing.front.web.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SuperServiceImpl {

    private SessionFactory sessionFactory;
	 
    public SuperServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


	public Session getSession() {
		return this.sessionFactory.openSession();
	}
}