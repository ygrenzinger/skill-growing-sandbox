package com.carbon.ecommerce.back.api.category;

import com.carbon.ecommerce.domain.Team;

import java.util.ArrayList;
import java.util.List;

public class CategoryRequestBuilder {

  private List<Team> categories;

    private CategoryRequestBuilder(){}

    public static CategoryRequestBuilder newBuilder(){
        return new CategoryRequestBuilder();
    }


    public CategoryRequestBuilder withCategories(List<String> categoriesLabel) {
        Team team;
        categories = new ArrayList<>();
        if(categoriesLabel != null) {
            for (String categoryLabel : categoriesLabel) {
                team = new Team();
                team.setName(categoryLabel);
                categories.add(team);
            }
        }
        return this;
    }


    public List<Team> build() {
        return categories;
    }
}
