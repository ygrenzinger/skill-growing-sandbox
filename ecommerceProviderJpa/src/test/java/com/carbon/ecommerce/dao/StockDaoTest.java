package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.Size;
import com.carbon.ecommerce.domain.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = {"classpath:test-jpa-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
public class StockDaoTest {

    @Autowired
    private StockDao stockDao;

    @Autowired
    private ItemDao itemDao;

    private void addStockSize(List<Stock> stocks, Size size) {
        Stock stock = new Stock();
        stock.setItem(TestsFactory.createItem());
        stock.setAvailable(1);
        stock.setSize(size);
        stocks.add(stock);
    }

    @Test
    @Transactional
    public void saveStock() {
        List<Stock> stocks = new ArrayList<>();
        addStockSize(stocks, Size.S);
        addStockSize(stocks, Size.M);
        stocks = stockDao.insertStocks(stocks);
        assertThat(stocks.size()).isEqualTo(2);
        assertThat(stocks.get(0).getId()).isPositive();
        assertThat(stocks.get(0).getSize()).isEqualTo(Size.S);
        assertThat(stocks.get(0).getItem()).isNotNull();
        assertThat(stocks.get(1).getId()).isPositive();
        assertThat(stocks.get(1).getSize()).isEqualTo(Size.M);
        assertThat(stocks.get(1).getItem()).isNotNull();
    }

    @Test
    @Transactional
    public void  allStocks() {
        Item item = itemDao.findItemByID(1L);
        List<Stock> stocks = stockDao.allStocks(item);
        assertThat(stocks.size()).isEqualTo(2);
        assertThat(stocks.get(0).getId()).isEqualTo(1);
        assertThat(stocks.get(0).getSize()).isEqualTo(Size.S);
        assertThat(stocks.get(0).getItem()).isNotNull();
        assertThat(stocks.get(1).getId()).isEqualTo(2);
        assertThat(stocks.get(1).getSize()).isEqualTo(Size.M);
        assertThat(stocks.get(1).getItem()).isNotNull();
    }

    @Test
    @Transactional
    public void existStocks() {
        Item item = itemDao.findItemByID(1L);
        assertThat(stockDao.existStock(item, 2, Size.S)).isTrue();
        assertThat(stockDao.existStock(item, 2, Size.M)).isFalse();
    }

}