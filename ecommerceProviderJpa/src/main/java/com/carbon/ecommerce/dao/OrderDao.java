package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.LinkOrderItem;
import com.carbon.ecommerce.domain.LinkOrderItemPk;
import com.carbon.ecommerce.domain.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDao extends SuperDAO {

	public void saveOrder(List<Item> items, Order order, Integer quantity) {
		LinkOrderItem linkOrderItem;
		order = (Order) merge(order);
		for (Item item: items){
			linkOrderItem = new LinkOrderItem(new LinkOrderItemPk(item, order), quantity);
			merge(linkOrderItem);
		}
	}
}
