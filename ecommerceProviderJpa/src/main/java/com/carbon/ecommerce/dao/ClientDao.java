package com.carbon.ecommerce.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.carbon.ecommerce.domain.Client;

@Repository
public class ClientDao extends SuperDAOImpl implements IClientDao {

	public ClientDao(){
		super();
	}
	
	@Override
	public Client find(String login, String password) {
		Query query = createQuery("from Client where email = :email and password = :password");
		query.setString("email", login);
		query.setString("password", password);
		Client client = (Client) query.uniqueResult();
		return client;
	}

	@Override
	public Client findByLogin(String login) {
		Query query = createQuery("from Client where email = :email");
		query.setString("email", login);
		Client client = (Client) query.uniqueResult();
		return client;
	}

	@Override
	public Client saveClient(Client client) {
		client.setId((Long)save(client));
		return client;
	}
}
