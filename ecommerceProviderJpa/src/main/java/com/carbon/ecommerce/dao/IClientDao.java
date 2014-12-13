package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Client;

public interface IClientDao extends ISuperDAO {
	
	Client find(String login, String password);
	Client findByLogin(String login);
	Client saveClient(Client client);
}
