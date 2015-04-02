package com.carbon.skillsgrowing.front.web.api.category;

import com.carbon.ecommerce.backoffice.api.Product;
import com.carbon.ecommerce.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class ProductBuilder {

    private List<Item> products;

    private ProductBuilder(){}

    public static ProductBuilder newBuilder(){
        return new ProductBuilder();
    }


    public ProductBuilder withProducts(List<Product> productsInput) {
        Item product;
        products = new ArrayList<>();
        if(productsInput != null) {
            for (Product currentProduct : productsInput) {
                product = new Item();
                product.setComposition(currentProduct.getComposition());
                product.setDescription(currentProduct.getDescription());
                product.setReference(currentProduct.getReference());
                product.setPrice(currentProduct.getPrice());
                products.add(product);
            }
        }
        return this;
    }


    public List<Item> build() {
        return products;
    }
}
