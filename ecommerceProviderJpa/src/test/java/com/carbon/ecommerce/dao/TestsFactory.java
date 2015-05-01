package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Item;

public class TestsFactory {

    public static Item createItem() {
        Item item = new Item();
        item.setComposition("test");
        item.setDescription("test");
        item.setPrice(123.45f);
        item.setReference(1);
        return item;
    }

}
