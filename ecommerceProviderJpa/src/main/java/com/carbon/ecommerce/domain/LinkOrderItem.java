package com.carbon.ecommerce.domain;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "LINK_ORDER_ITEM")
@AssociationOverrides({
	@AssociationOverride(name = "linkOrderItemPk.item", 
		joinColumns = @JoinColumn(name = "id_item")),
	@AssociationOverride(name = "linkOrderItemPk.order", 
		joinColumns = @JoinColumn(name = "id_order")) })

public class LinkOrderItem implements Serializable{


	private static final long serialVersionUID = 1693203709704347557L;

	@EmbeddedId
	private LinkOrderItemPk	linkOrderItemPk	= new LinkOrderItemPk();

	private Integer quantity;
	
	public LinkOrderItem() {
	}
	
	public LinkOrderItem(LinkOrderItemPk linkOrderItemPk,
			Integer quantity) {
		super();
		this.linkOrderItemPk = linkOrderItemPk;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LinkOrderItemPk getLinkOrderItemPk() {
		return linkOrderItemPk;
	}

	public void setLinkOrderItemPk(LinkOrderItemPk linkOrderItemPk) {
		this.linkOrderItemPk = linkOrderItemPk;
	}

}