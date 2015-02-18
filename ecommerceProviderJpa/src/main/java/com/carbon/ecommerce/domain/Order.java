package com.carbon.ecommerce.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_ITEM")
public class Order implements Serializable{

	private static final long serialVersionUID = 8026049918975675935L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "REFERENCE_ID")
	private List<Item> items;
	
	@Column(name = "ISVALIDATE")
	private Integer isValidate;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getIsValidate() {
		return isValidate;
	}
	public void setIsValidate(Integer isValidate) {
		this.isValidate = isValidate;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}
}