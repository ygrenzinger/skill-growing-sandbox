package com.carbon.ecommerce.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.carbon.ecommerce.utils.Authentification;

@Component
public class LoginValidator implements Validator {
 
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	 @Override
	 public boolean supports(Class<?> clazz) {
		 return Authentification.class.equals(clazz);
	 }
 
 	@Override
	 public void validate(Object target, Errors errors) {
 		Authentification authentification = (Authentification) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.mandatory","an error occur");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.mandatory","an error occur");
		 
		Matcher matcherMail = Pattern.compile(EMAIL_PATTERN).matcher(authentification.getLogin());
		if (!matcherMail.matches()) {
			errors.rejectValue("login",
					"mail.format.incorrect");
		}
	 }
}
