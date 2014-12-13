package com.carbon.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.carbon.ecommerce.utils.Session;

public abstract class SuperController {
	
	@Autowired
    protected Session sessionBean;
}