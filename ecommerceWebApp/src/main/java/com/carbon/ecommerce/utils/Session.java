package com.carbon.ecommerce.utils;

import org.springframework.stereotype.Component;

import com.carbon.ecommerce.domain.Client;

@Component
//@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Session {
	
	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public boolean isConnected(){
		return client != null;
	}
}
