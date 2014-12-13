package com.carbon.ecommerce.utils;

import com.carbon.ecommerce.domain.Client;

public class ClientBuilder {

	private String name;
	private String firstName;
	private String email;
	private String password;
	
	public ClientBuilder(){
	}

	public ClientBuilder name(String name) {
         this.name = name;
         return this;
     }
	  
	 public ClientBuilder firstName(String firstName) {
	         this.firstName = firstName;
	         return this;
   }
	  
	  public ClientBuilder email(String email) {
	         this.email = email;
	         return this;
	  }
	  
	  public ClientBuilder password(String password) {
	         this.password = password;
	         return this;
	 }
	  
	  public Client createClient(){
         return new Client(
            name, firstName, email, password);
      }
}
