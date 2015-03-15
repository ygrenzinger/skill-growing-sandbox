package com.carbon.skillsgrowing.front.web.api.category;

import com.carbon.ecommerce.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRequestBuilder {

  private List<Category> categories;

    private CategoryRequestBuilder(){}

    public static CategoryRequestBuilder newBuilder(){
        return new CategoryRequestBuilder();
    }


    public CategoryRequestBuilder withCategories(List<String> categoriesLabel) {
        Category category;
        categories = new ArrayList<>();
        if(categoriesLabel != null) {
            for (String categoryLabel : categoriesLabel) {
                category = new Category();
                category.setName(categoryLabel);
                categories.add(category);
            }
        }
        return this;
    }


    public List<Category> build() {
        return categories;
    }
}
