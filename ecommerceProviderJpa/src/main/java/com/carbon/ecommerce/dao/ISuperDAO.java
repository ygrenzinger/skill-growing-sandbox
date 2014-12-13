package com.carbon.ecommerce.dao;

import org.hibernate.Session;



/**
 * @author Najate
 *
 */
public interface ISuperDAO {
	
	public Session getSession();
	
	public void setSession(Session session);
}
