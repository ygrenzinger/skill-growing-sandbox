package com.carbon.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.Stock;

@Repository
public class StockDao extends SuperDAOImpl implements IStockDao {

	public StockDao(){
		super();
	}
	
	@Override
	public List<Stock> insertStocks(List<Stock> stocks) {
		List<Stock> result = new ArrayList<>();
		for (Stock stock: stocks){
			stock.setId((Long)save(stock));
			result.add(stock);
		}
		return result;
	}
	
	public boolean existStock(Item item, Integer quantity) {
		Query query = createQuery("from Stock where item.id = :idItem");
		query.setLong("idItem", item.getId());
		Stock stock = (Stock) query.uniqueResult();
		return stock != null && stock.getStock() - quantity > 0;
	}
}
