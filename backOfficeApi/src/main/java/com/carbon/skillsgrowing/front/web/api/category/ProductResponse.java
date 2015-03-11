package com.carbon.skillsgrowing.front.web.api.category;

import com.carbon.ecommerce.domain.Item;
import com.carbon.skillsgrowing.front.web.model.Error;

import java.util.List;

public class ProductResponse {

    public ProductRequest productRequest;
    public List<Item> products;
    public Error error;

    public void setError(Error error) {
        this.error = error;
    }

    public void setProductRequest(ProductRequest productRequest) {
        this.productRequest = productRequest;
    }

    public void setProducts(List<Item> products) {
        this.products = products;
    }
}

