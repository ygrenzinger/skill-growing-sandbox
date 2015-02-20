package com.carbon.ecommerce.dao;

import java.util.List;

import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.Order;

public interface IOrderDao extends ISuperDAO {

	void saveOrder(List<Item> items, Order order,
			Integer quantity);
}
