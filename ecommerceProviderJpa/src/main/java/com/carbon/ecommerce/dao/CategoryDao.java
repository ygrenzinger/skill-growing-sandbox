package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Category;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao extends SuperDAOImpl{

	public CategoryDao(){
		super();
	}
	
	public Category find(Long id) {
		Query query = createQuery("from Category where id = :id");
		query.setLong("id", id);
        Category category = (Category) query.uniqueResult();
		return category;
	}

    public List<Category> findAllCategories() {
        Query query = createQuery("from Category");
        List<Category>  categories = (List<Category> ) query.list();
        return categories;
    }

	public Category saveCategory(Category category) {
        category.setId((Long)save(category));
		return category;
	}
}
