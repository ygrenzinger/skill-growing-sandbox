package com.carbon.ecommerce.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class SuperDAO {

    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Object merge(Object object) {
        return sessionFactory.getCurrentSession().merge(object);
    }

    protected Query createQuery(String queryString) {
        return sessionFactory.getCurrentSession().createQuery(queryString);
    }

}
