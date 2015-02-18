package com.carbon.ecommerce.dao;

import java.util.List;

import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.Stock;

public interface IITemDao extends ISuperDAO {
	
	List<Item> findItem();
	
	 List<Stock> insertItems();
	 
	 void updateItemBouchon(List<Stock> stocks);
	 
	 boolean isAvailableStock(Item item, Integer quantity);
}
