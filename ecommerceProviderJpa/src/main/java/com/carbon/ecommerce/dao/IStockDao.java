package com.carbon.ecommerce.dao;

import java.util.List;

import com.carbon.ecommerce.domain.Stock;


public interface IStockDao extends ISuperDAO {
	
	List<Stock> insertStocks(List<Stock> stocks);
}
