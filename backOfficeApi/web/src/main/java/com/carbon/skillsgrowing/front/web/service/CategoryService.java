package com.carbon.skillsgrowing.front.web.service;

import com.carbon.ecommerce.dao.CategoryDao;
import com.carbon.ecommerce.domain.Category;
import com.carbon.skillsgrowing.front.web.service.SuperServiceImpl;
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
public class CategoryService extends SuperServiceImpl {

    private final static Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryDao categoryDao;

    @Inject
    public CategoryService(CategoryDao categoryDao, SessionFactory sessionFactory)
    {
        super(sessionFactory);
        this.categoryDao = categoryDao;
    }

    @Transactional
    public List<com.carbon.ecommerce.backoffice.api.Category> createCategories(List<Category> categories) {
        categoryDao.setSession(getSession());
        List<com.carbon.ecommerce.backoffice.api.Category> result = new ArrayList<>();
        Mapper mapper = new DozerBeanMapper();
        for (Category category : categories){
            Category savedCategory = categoryDao.saveCategory(category);
            com.carbon.ecommerce.backoffice.api.Category cat =
                    mapper.map(savedCategory, com.carbon.ecommerce.backoffice.api.Category.class);
            result.add(cat);
        }
        return result;
    }

    @Transactional
    public List<com.carbon.ecommerce.backoffice.api.Category> getCategories() {
        List<com.carbon.ecommerce.backoffice.api.Category> result = new ArrayList<>();
        categoryDao.setSession(getSession());
        List<Category> allCategories = categoryDao.findAllCategories();
        Mapper mapper = new DozerBeanMapper();
        for (Category category : allCategories){
            com.carbon.ecommerce.backoffice.api.Category cat =
                    mapper.map(category, com.carbon.ecommerce.backoffice.api.Category.class);
            result.add(cat);
        }
        return result;
    }

    @Transactional
    public Category searchCategory(long categoryId)
    {
        categoryDao.setSession(getSession());
        return categoryDao.find(categoryId);
    }
}
