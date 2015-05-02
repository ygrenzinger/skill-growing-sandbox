package com.carbon.ecommerce.back.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SuperServiceImpl {

    private SessionFactory sessionFactory;
	 
    public SuperServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
}
