package com.carbon.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.carbon.ecommerce.domain.Client;
import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.exception.BusinessException;
import com.carbon.ecommerce.service.IClientService;
import com.carbon.ecommerce.service.IItemService;
import com.carbon.ecommerce.utils.Authentification;
import com.carbon.ecommerce.validator.LoginValidator;

@Controller
public class LoginController extends SuperController{

    private static final String VIEW_HOME = "home";
    private static final String VIEW_LOGIN = "login";

    @Autowired
    private IClientService clientService;
    
    @Autowired
    private IItemService itemService;

    @InitBinder(value = "authentication")
	protected void initBinder(WebDataBinder binder) {
    	binder.setValidator(new LoginValidator());
	 }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcome(ModelMap model) {
        model.put("authentication", new Authentification());
        return new ModelAndView(VIEW_LOGIN, model);
    }

    @RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
    public ModelAndView validateLogin(@Valid @ModelAttribute("authentication") Authentification authentification, BindingResult bindingResult,
                                       ModelMap model) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView(VIEW_LOGIN, model);
        } else {
            try {
				findClient(authentification, model);
				findItems(model);
				getSize(model);
			} 
            catch (BusinessException e) {
			}
            catch (Exception e) {
				bindingResult.addError(new FieldError("clientError",
						"clientError",
						e.getMessage()));
				return new ModelAndView(VIEW_LOGIN, model);
			}
            return new ModelAndView(VIEW_HOME, model);
        }
    }

	private void getSize(ModelMap model) {
		//model.put("size", itemService.findSize());
	}

	private void findClient(Authentification authentification, ModelMap model)
			throws BusinessException {
		Client client = clientService.findClient(authentification.getLogin(), authentification.getPassword());
		sessionBean.setClient(client);
		model.addAttribute("name", client.getName());
		model.addAttribute("firstname", client.getFirstname());
	}

	private void findItems(ModelMap model) throws BusinessException {
		List<Item> items = new ArrayList<>();
		items = itemService.findItem();
		model.put("items", items);
	}
    
    @RequestMapping(value = "/createItems", method = RequestMethod.POST)
    public ModelAndView createItems(ModelMap model) {
    	itemService.insertItems();
    	model.put("authentication", new Authentification());
    	return new ModelAndView(VIEW_LOGIN, model);
    }
}