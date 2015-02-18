package com.carbon.ecommerce.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carbon.ecommerce.domain.Client;
import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.Stock;

@Repository
public class ItemDao extends SuperDAOImpl implements IITemDao {

	public ItemDao(){
		super();
	}

	@Autowired
	private Item itemBouchon1;
	
	@Autowired
	private Item itemBouchon2;
	
	@Autowired
	private Item itemBouchon3;
	
	@Autowired
	private Item itemBouchon4;
	
	@Autowired
	private Stock stock11;
	
	@Autowired
	private Stock stock12;
	
	@Autowired
	private Stock stock13;
	
	@Autowired
	private Stock stock21;
	
	@Autowired
	private Stock stock22;
	
	@Autowired
	private Stock stock23;
	
	@Autowired
	private Stock stock31;
	
	@Autowired
	private Stock stock32;
	
	@Autowired
	private Stock stock33;
	
	@Autowired
	private Stock stock41;
	
	@Autowired
	private Stock stock42;
	
	@Autowired
	private Stock stock43;
	
	@Override
	public List<Item> findItem() {
		Query query = createQuery("from Item");
		List<Item> items = (List<Item>) query.list();
		return items;
	}

	@Override
	public List<Stock> insertItems() {
		List<Stock> result = new ArrayList<>();
		itemBouchon1.setId((Long)save(itemBouchon1));
		
		stock11.setItem(itemBouchon1);
		stock12.setItem(itemBouchon1);
		stock13.setItem(itemBouchon1);
				
		itemBouchon2.setId((Long)save(itemBouchon2));
		stock21.setItem(itemBouchon2);
		stock22.setItem(itemBouchon2);
		stock23.setItem(itemBouchon2);
		
		itemBouchon3.setId((Long)save(itemBouchon3));
		stock31.setItem(itemBouchon3);
		stock32.setItem(itemBouchon3);
		stock33.setItem(itemBouchon3);
		
		
		itemBouchon4.setId((Long)save(itemBouchon4));
		stock41.setItem(itemBouchon4);
		stock42.setItem(itemBouchon4);
		stock43.setItem(itemBouchon4);
		
		result.add(stock11);
		result.add(stock12);
		result.add(stock13);
		
		result.add(stock21);
		result.add(stock22);
		result.add(stock23);
		
		result.add(stock31);
		result.add(stock32);
		result.add(stock33);
		
		result.add(stock41);
		result.add(stock42);
		result.add(stock43);
		return result;
	}
	
	@Override
	public void updateItemBouchon(List<Stock> stocks){
		List<Item> items = findItem();
		for (Item item : items){
			for (Stock stock : stocks) {
				if (item.getId() == stock.getItem().getId()){
					if (item.getStocks() == null) {
						item.setStocks(new HashSet<Stock>());
					}
					item.getStocks().add(stock);
					update(item);
				}
			}
		}
	}
	
	@Override
	public boolean isAvailableStock(Item item, Integer quantity) {
		Query query = createQuery("from Stock where item.id = :itemId");
		query.setLong("itemId", item.getId());
		Stock stock = (Stock) query.uniqueResult();
		if (stock == null || stock.getStock() < quantity) {
			return false;
		}
		return true;
	}
}
