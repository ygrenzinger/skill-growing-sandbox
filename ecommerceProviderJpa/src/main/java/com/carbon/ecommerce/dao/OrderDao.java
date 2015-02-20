package com.carbon.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.LinkOrderItem;
import com.carbon.ecommerce.domain.LinkOrderItemPk;
import com.carbon.ecommerce.domain.Order;

@Repository
public class OrderDao extends SuperDAOImpl implements IOrderDao {

	@Override
	public void saveOrder(List<Item> items, Order order,
			Integer quantity) {
		LinkOrderItem linkOrderItem;
		order.setId((Long)save(order));
		for (Item item: items){
			linkOrderItem = new LinkOrderItem(new LinkOrderItemPk(item, order), quantity);
			save(linkOrderItem);
		}
	}
}
