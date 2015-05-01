package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.Stock;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

public class ItemDao extends SuperDAO {

    public Item saveItem(Item item){
        return (Item) merge(item);
    }

	public Item findItemByID(Long id) {
		Query query =createQuery("from Item where id = :itemId");
		query.setLong("itemId", id);
		return (Item) query.uniqueResult();
	}

	public boolean isAvailableStock(Item item, Integer quantity) {
		Query query =createQuery("from Stock where item.id = :itemId");
		query.setLong("itemId", item.getId());
		Stock stock = (Stock) query.uniqueResult();
		return !(stock == null || stock.getAvailable() < quantity);
	}

    public List<Item> findAllItems() {
        Query query =createQuery("from Item");
        List<Item>  items = (List<Item> ) query.list();
        return items;
    }
}
