package com.carbon.skillsgrowing.front.web.service;

import com.carbon.ecommerce.dao.CategoryDao;
import com.carbon.ecommerce.domain.Category;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService extends SuperServiceImpl {

    private final static Logger logger = LoggerFactory.getLogger(CategoryService.class);
    private CategoryDao categoryDao;

    @Inject
    public CategoryService(CategoryDao categoryDao, SessionFactory sessionFactory)
    {
        super(sessionFactory);
        this.categoryDao = categoryDao;
    }

    @Transactional
    public List<Category> createCategories(List<Category> categories) {
        categoryDao.setSession(getSession());
        List<Category> result = new ArrayList<>();
        for (Category category : categories){
            result.add(categoryDao.saveCategory(category));
        }
        return result;
    }

    @Transactional
    public List<Category> getCategories() {
        categoryDao.setSession(getSession());
        return categoryDao.findAllCategories();
    }

    @Transactional
    public Category searchCategory(long categoryId)
    {
        categoryDao.setSession(getSession());
        return categoryDao.find(categoryId);
    }
}
