package com.carbon.ecommerce.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SuperServiceImpl  implements ISuperService{

	private SessionFactory sessionFactory;
	 
    public SuperServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public Session getSession() {
		return this.sessionFactory.openSession();
	}
}
