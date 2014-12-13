package com.carbon.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

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
}
