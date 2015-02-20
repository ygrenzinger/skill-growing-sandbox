package com.carbon.ecommerce.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
@AssociationOverrides({ 
	@AssociationOverride(name = "linkOrderItemPk.item", joinColumns = @JoinColumn(name = "id_item")), 
	@AssociationOverride(name = "linkOrderItemPk.order", joinColumns = @JoinColumn(name = "id_order"))
	})
public class Order implements Serializable{

	private static final long serialVersionUID = 8026049918975675935L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "REFERENCE_ID")
	private List<LinkOrderItem> items;
	
	@Column(name = "ISVALIDATE")
	private Integer isValidate;
	
	public Order(){
		super();
	}
	
	public Order(Client client){
		this.client = client;
	}
	
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
}