package com.carbon.ecommerce.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_ORDERED")
public class ItemOrdered implements Serializable{


	private static final long serialVersionUID = 1693203709704347557L;

	@EmbeddedId
	private LinkOrderItemPk	linkOrderItemPk	= new LinkOrderItemPk();

	private Integer quantity;
	
	public ItemOrdered() {
	}
	
	public ItemOrdered(LinkOrderItemPk linkOrderItemPk,
			Integer quantity) {
		super();
		this.linkOrderItemPk = linkOrderItemPk;
	}

	public LinkOrderItemPk getLinkOrderItemPk() {
		return linkOrderItemPk;
	}

	public void setLinkOrderItemPk(LinkOrderItemPk linkOrderItemPk) {
		this.linkOrderItemPk = linkOrderItemPk;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}