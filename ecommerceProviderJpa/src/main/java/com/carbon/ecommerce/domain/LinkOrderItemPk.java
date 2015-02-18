package com.carbon.ecommerce.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class LinkOrderItemPk implements Serializable{

	private static final long serialVersionUID = 714547624017634047L;

	@ManyToOne
	private Item item;
	
	@ManyToOne
	private Order order;

	public LinkOrderItemPk(){
		super();
	}

	public LinkOrderItemPk(Item item, Order order) {
		super();
		this.item = item;
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LinkOrderItemPk other = (LinkOrderItemPk) obj;
		if (item == null) {
			if (other.item != null) {
				return false;
			}
		} else if (!item.equals(other.item)) {
			return false;
		}
		if (order == null) {
			if (other.order != null) {
				return false;
			}
		} else if (!order.equals(other.order)) {
			return false;
		}
		return true;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}