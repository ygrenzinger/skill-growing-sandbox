package com.carbon.skillsgrowing.front.web.service;

import com.carbon.ecommerce.dao.ItemDao;
import com.carbon.ecommerce.domain.Category;
import com.carbon.ecommerce.domain.Item;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends SuperServiceImpl  {

    private final static Logger logger = LoggerFactory.getLogger(ProductService.class);
    private ItemDao productDao;

    @Inject
    public ProductService(ItemDao productDao, SessionFactory sessionFactory) {
        super(sessionFactory);
        this.productDao = productDao;
    }

    @Transactional
    public List<Item> createProducts(List<Item> items, Category currentCategory) {
        productDao.setSession(getSession());
        List<Item> result = new ArrayList<>();
        for (Item item : items){
            item.setCategory(currentCategory);
            result.add(productDao.saveItem(item));
        }
        return result;
    }

    @Transactional
    public List<Item> getProducts() {
        productDao.setSession(getSession());
        return productDao.findAllProducts();

    }
}
