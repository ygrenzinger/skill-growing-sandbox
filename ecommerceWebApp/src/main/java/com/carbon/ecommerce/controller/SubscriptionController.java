package com.carbon.ecommerce.controller;

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
import com.carbon.ecommerce.exception.BusinessException;
import com.carbon.ecommerce.service.IClientService;
import com.carbon.ecommerce.utils.Authentification;
import com.carbon.ecommerce.utils.ClientBuilder;
import com.carbon.ecommerce.utils.Subscription;
import com.carbon.ecommerce.validator.ClientValidator;

@Controller
public class SubscriptionController extends SuperController{

	private static final String VIEW_LOGIN = "login";
	private static final String VIEW_SUBSCRIPTION = "subscription";

	@Autowired
	private IClientService clientService;

	@InitBinder(value = "userSubscription")
	 protected void initBinder(WebDataBinder binder) {
	  binder.setValidator(new ClientValidator());
	 }
	
	@RequestMapping(value = "/subscription", method = RequestMethod.GET)
	public ModelAndView welcome(ModelMap model) {
		model.put("userSubscription", new Subscription());
		return new ModelAndView("subscription", model);
	}

	@RequestMapping(value = "/validateSubscription", method = RequestMethod.POST)
	public ModelAndView validateSubscription(
			
			@Valid @ModelAttribute("userSubscription") Subscription subscription,
			BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(VIEW_SUBSCRIPTION, model);
		} else {
			ClientBuilder builder = new ClientBuilder();
			builder.name(subscription.getName());
			builder.firstName(subscription.getFirstname());
			builder.email(subscription.getMail());
			builder.password(subscription.getPassword());
			try {
				Client client = clientService.subscribeAccount(builder.createClient());
				sessionBean.setClient(client);
			} catch (BusinessException e) {
				bindingResult.addError(new FieldError("clientError",
						"clientError",
						e.getMessage()));
				return new ModelAndView(VIEW_SUBSCRIPTION, model);
			}
			model.put("authentication", new Authentification());
			return new ModelAndView(VIEW_LOGIN, model);
		}
	}
}
