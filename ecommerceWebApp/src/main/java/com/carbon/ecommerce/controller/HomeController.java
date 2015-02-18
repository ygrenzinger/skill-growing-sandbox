package com.carbon.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.carbon.ecommerce.service.IItemService;

@Controller
public class HomeController extends SuperController{

    @Autowired
    private IItemService itemService;
    
    @RequestMapping(value = "/addBasket", method = RequestMethod.POST)
    public ModelAndView welcome(ModelMap model) {
    	int t = 0;
		return new ModelAndView("home", model);
    }

}