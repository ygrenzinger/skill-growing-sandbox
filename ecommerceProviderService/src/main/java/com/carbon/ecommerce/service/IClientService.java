package com.carbon.ecommerce.service;

import com.carbon.ecommerce.domain.Client;
import com.carbon.ecommerce.exception.BusinessException;


public interface IClientService {

	Client subscribeAccount(Client client) throws BusinessException ;
	
	Client findClient(String login, String password) throws BusinessException ;
}
