package com.carbon.ecommerce.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carbon.ecommerce.domain.Client;

public class ClientDao extends SuperDAO {

	public Client find(String login, String password) {
		Query query = createQuery("from Client where email = :email and password = :password");
		query.setString("email", login);
		query.setString("password", password);
		Client client = (Client) query.uniqueResult();
		return client;
	}

	public Client findByLogin(String login) {
		Query query = createQuery("from Client where email = :email");
		query.setString("email", login);
		Client client = (Client) query.uniqueResult();
		return client;
	}

	public Client saveClient(Client client) {
		return (Client) merge(client);
	}
}
