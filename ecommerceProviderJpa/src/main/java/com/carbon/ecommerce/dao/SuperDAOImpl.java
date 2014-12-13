package com.carbon.ecommerce.dao;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;

public class SuperDAOImpl  implements ISuperDAO{

	private Session session;
	
	@Override
	public Session getSession() {
		return session;
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	protected Serializable save(Object object) {
		return this.getSession().save(object);
	}
	
	protected Query createQuery(String queryString) {
		return this.getSession().createQuery(queryString);
	}
	
	protected void update(Object object) {
		this.session.update(object);
	}
	
}
