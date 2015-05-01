package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.Size;
import com.carbon.ecommerce.domain.Stock;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

public class StockDao extends SuperDAO {

    public List<Stock> insertStocks(List<Stock> stocks) {
        List<Stock> result = new ArrayList<>();
        for (Stock stock : stocks) {
            result.add((Stock) merge(stock));
        }
        return result;
    }

    public boolean existStock(Item item, Integer quantity, Size size) {
        Query query = createQuery("from Stock where item.id = :idItem and size = :size");
        query.setLong("idItem", item.getId());
        query.setString("size", size.name());
        Stock stock = (Stock) query.uniqueResult();
        return stock != null && stock.getAvailable() - quantity > 0;
    }

    public List<Stock> allStocks(Item item) {
        Query query = createQuery("from Stock where item.id = :idItem");
        query.setLong("idItem", item.getId());
        return (List<Stock>)query.list();
    }
}
