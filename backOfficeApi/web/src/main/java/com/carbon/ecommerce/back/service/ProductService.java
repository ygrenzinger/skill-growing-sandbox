package com.carbon.ecommerce.back.service;

import com.carbon.ecommerce.dao.ItemDao;
import com.carbon.ecommerce.domain.Team;
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
public class ProductService extends SuperServiceImpl {

    private final static Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ItemDao productDao;

    @Inject
    public ProductService(ItemDao productDao, SessionFactory sessionFactory) {
        super(sessionFactory);
        this.productDao = productDao;
    }

    @Transactional
    public List<com.carbon.ecommerce.backoffice.api.Product> createProducts(List<Item> products, Team currentTeam) {
        List<com.carbon.ecommerce.backoffice.api.Product> result = new ArrayList<>();
        Mapper mapper = new DozerBeanMapper();
        for (Item product : products) {
            product.setTeam(currentTeam);
            Item temporaryProduct = productDao.saveItem(product);
            com.carbon.ecommerce.backoffice.api.Product finalProduct =
                    mapper.map(temporaryProduct, com.carbon.ecommerce.backoffice.api.Product.class);
            result.add(finalProduct);
        }
        return result;
    }

    @Transactional
    public List<com.carbon.ecommerce.backoffice.api.Product> getProducts() {
        List<com.carbon.ecommerce.backoffice.api.Product> result = new ArrayList<>();
        Mapper mapper = new DozerBeanMapper();
        List<Item> allProducts = productDao.findAllItems();
        for (Item item : allProducts) {
            com.carbon.ecommerce.backoffice.api.Product finalProduct =
                    mapper.map(item, com.carbon.ecommerce.backoffice.api.Product.class);
            result.add(finalProduct);
        }
        return result;

    }
}
