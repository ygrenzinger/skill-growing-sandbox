package com.carbon.skillsgrowing.front.web.api.category;

import com.carbon.ecommerce.domain.Category;
import com.carbon.skillsgrowing.front.web.model.Error;

import java.util.List;

public class CategoryResponse {

    public CategoryRequest categoryRequest;
    public List<Category> categories;
    public Error error;

    public void setError(Error error) {
        this.error = error;
    }

    public void setCategoryRequest(CategoryRequest categoryRequest) {
        this.categoryRequest = categoryRequest;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}

