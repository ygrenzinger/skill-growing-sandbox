package com.carbon.skillsgrowing.front.web.api.category;

import com.carbon.ecommerce.domain.Category;
import com.carbon.skillsgrowing.front.web.model.Error;

public class CategoryResponse {

    public CategoryRequest categoryRequest;
    public Category category;
    public Error error;

    public void setError(Error error) {
        this.error = error;
    }

    public void setCategoryRequest(CategoryRequest categoryRequest) {
        this.categoryRequest = categoryRequest;
    }
}

