package com.carbon.ecommerce.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.carbon.ecommerce.utils.Subscription;

@Component
public class ClientValidator implements Validator {
 
	
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	 @Override
	 public boolean supports(Class<?> clazz) {
		 return Subscription.class.equals(clazz);
	 }
 
 	@Override
	 public void validate(Object target, Errors errors) {
		 Subscription futurClient = (Subscription)target;
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "client.name.mandatory","an error occur");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "client.firstname.mandatory","an error occur");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "client.email.mandatory","an error occur");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmationMail", "client.confirmation.email.mandatory","an error occur");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "client.password.mandatory","an error occur");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmationPassword", "client.confirmation.password.mandatory","an error occur");
		 if (!futurClient.getMail().equals(
				 futurClient.getConfirmationMail())) {
			 errors.rejectValue("confirmationMail",
						"client.confirmation.email.incorrect");
			}
			if (!futurClient.getPassword().equals(
					futurClient.getConfirmationPassword())) {
				errors.rejectValue("confirmationPassword",
						"client.confirmation.password.incorrect");
			}
			Matcher matcherMail = Pattern.compile(EMAIL_PATTERN).matcher(futurClient.getMail());
			Matcher matcherConfirmMail = Pattern.compile(EMAIL_PATTERN).matcher(futurClient.getConfirmationMail());
			if (!matcherMail.matches()) {
				errors.rejectValue("mail",
						"mail.format.incorrect");
			}
			if (!matcherConfirmMail.matches()) {
				errors.rejectValue("confirmationMail",
						"mail.format.incorrect");
			}
	 }
}
