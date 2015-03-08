package com.carbon.skillsgrowing.front.web.api.category;

import com.carbon.ecommerce.domain.Category;

import java.util.List;

public class CategoryRequest {

  public List<Category> categories;

    public CategoryRequest(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryRequest that = (CategoryRequest) o;

        if (categories != null ? !categories.equals(that.categories) : that.categories != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return categories != null ? categories.hashCode() : 0;
    }
}
