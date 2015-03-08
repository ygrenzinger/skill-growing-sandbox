package com.carbon.skillsgrowing.front.web.api.category;

import com.carbon.ecommerce.domain.Item;

import java.util.List;

public class ProductRequest {

  public List<Item> products;

    public ProductRequest(List<Item> products){
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductRequest that = (ProductRequest) o;

        if (products != null ? !products.equals(that.products) : that.products != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return products != null ? products.hashCode() : 0;
    }
}
