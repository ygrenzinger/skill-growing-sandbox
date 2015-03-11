package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.Stock;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao extends SuperDAOImpl {

	public ItemDao(){
		super();
	}

    public Item saveItem(Item item){
        item.setId((Long)save(item));
        return item;
    }

	public List<Item> findItem() {
		Query query = createQuery("from Item");
		List<Item> items = (List<Item>) query.list();
		return items;
	}

	public boolean isAvailableStock(Item item, Integer quantity) {
		Query query = createQuery("from Stock where item.id = :itemId");
		query.setLong("itemId", item.getId());
		Stock stock = (Stock) query.uniqueResult();
		if (stock == null || stock.getStock() < quantity) {
			return false;
		}
		return true;
	}

    public List<Item> findAllProducts() {
        Query query = createQuery("from Item");
        List<Item>  items = (List<Item> ) query.list();
        return items;
    }
}
