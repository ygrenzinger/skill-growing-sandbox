package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Category;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

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

	public Category saveCategory(Category category) {
        category.setId((Long)save(category));
		return category;
	}
}
