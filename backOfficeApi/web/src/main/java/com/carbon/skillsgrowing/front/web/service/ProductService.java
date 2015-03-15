package com.carbon.skillsgrowing.front.web.service;

import com.carbon.ecommerce.dao.ItemDao;
import com.carbon.ecommerce.domain.Category;
import com.carbon.ecommerce.domain.Item;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends SuperServiceImpl  {

    private final static Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ItemDao productDao;

    @Inject
    public ProductService(ItemDao productDao, SessionFactory sessionFactory) {
        super(sessionFactory);
        this.productDao = productDao;
    }

    @Transactional
    public List<com.carbon.skillsgrowing.front.web.api.Item> createProducts(List<Item> items, Category currentCategory) {
        productDao.setSession(getSession());
        List<com.carbon.skillsgrowing.front.web.api.Item> result = new ArrayList<>();
        Mapper mapper = new DozerBeanMapper();
        for (Item item : items){
            item.setCategory(currentCategory);
            Item temporaryItem = productDao.saveItem(item);
            com.carbon.skillsgrowing.front.web.api.Item finalItem =
                    mapper.map(temporaryItem, com.carbon.skillsgrowing.front.web.api.Item.class);
            result.add(finalItem);
        }
        return result;
    }

    @Transactional
    public List<com.carbon.skillsgrowing.front.web.api.Item> getProducts() {
        productDao.setSession(getSession());
        List<com.carbon.skillsgrowing.front.web.api.Item> result = new ArrayList<>();
        Mapper mapper = new DozerBeanMapper();
        List<Item> allProducts = productDao.findAllProducts();
        for (Item item : allProducts) {
            com.carbon.skillsgrowing.front.web.api.Item finalItem =
                    mapper.map(item, com.carbon.skillsgrowing.front.web.api.Item.class);
            result.add(finalItem);
        }
        return result;

    }
}
