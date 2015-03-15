package com.carbon.skillsgrowing.front.web.api.category;

import com.carbon.ecommerce.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class ProductRequestBuilder {

  private List<Item> products;

    private ProductRequestBuilder(){}

    public static ProductRequestBuilder newBuilder(){
        return new ProductRequestBuilder();
    }


    public ProductRequestBuilder withProducts(List<String> productsLabel) {
        Item product;
        products = new ArrayList<>();
        if(productsLabel != null) {
            for (String productLabel : productsLabel) {
                product = new Item();
                product.setComposition(productLabel);
                products.add(product);
            }
        }
        return this;
    }


    public List<Item> build() {
        return products;
    }
}
