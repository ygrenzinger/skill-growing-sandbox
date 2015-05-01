package com.carbon.ecommerce.service;

import com.carbon.ecommerce.dao.ClientDao;
import com.carbon.ecommerce.domain.Client;
import com.carbon.ecommerce.exception.BusinessException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService extends SuperServiceImpl implements IClientService {
	
	public ClientService(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	@Autowired
	private ClientDao clientDao;
	
	@Transactional
	@Override
	public Client subscribeAccount(Client client) throws BusinessException {
		Client clientFound = clientDao.findByLogin(client.getEmail());
		if (clientFound == null) {
			return	clientDao.saveClient(client);
		}
		else {
			throw new BusinessException("Un compte existe deja pour ce login.");
		}
	}

	@Transactional
	@Override
	public Client findClient(String login, String password) throws BusinessException {
		Client client = clientDao.find(login, password);
		if (client == null) {
			System.out.println("Aucun client n'a ete trouvee.");
			throw new BusinessException("Aucun client n'a ete trouve.");
		}
		return client;
	}
	
	
}
