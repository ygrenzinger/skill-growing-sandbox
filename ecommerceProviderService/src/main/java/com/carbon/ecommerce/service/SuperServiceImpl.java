package com.carbon.ecommerce.service;

import org.hibernate.SessionFactory;

public class SuperServiceImpl {

    private SessionFactory sessionFactory;

    public SuperServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
