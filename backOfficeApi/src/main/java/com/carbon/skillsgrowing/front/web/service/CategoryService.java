package com.carbon.skillsgrowing.front.web.service;

import com.carbon.ecommerce.dao.CategoryDao;
import com.carbon.ecommerce.domain.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final static Logger logger = LoggerFactory.getLogger(CategoryService.class);
    private CategoryDao categoryDao;

    @Inject
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> createCategories(List<Category> categories) {
        List<Category> result = new ArrayList<>();
        for (Category category : categories){
            result.add(categoryDao.saveCategory(category));
        }
        return result;
    }
}
