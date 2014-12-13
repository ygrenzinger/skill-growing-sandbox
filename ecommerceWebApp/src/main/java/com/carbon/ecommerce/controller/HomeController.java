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
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView welcome(ModelMap model) {
		return new ModelAndView("home", model);
    }
}