package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Item;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = {"classpath:test-jpa-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
public class ItemDaoTest {

    @Autowired
    private ItemDao itemDao;

    @Test
    @Transactional
    public void saveItem() {
        Item item = TestsFactory.createItem();
        Item savedItem = itemDao.saveItem(item);
        assertThat(savedItem.getId()).isPositive();
        assertThat(savedItem.getPrice()).isEqualTo(item.getPrice());
        assertThat(savedItem.getReference()).isEqualTo(item.getReference());
        assertThat(savedItem.getComposition()).isEqualTo(item.getComposition());
        assertThat(savedItem.getDescription()).isEqualTo(item.getDescription());
    }

    @Test
    @Transactional
    public void findAllItems() {
        List<Item> items = itemDao.findAllItems();
        assertThat(items).isNotEmpty();
        assertThat(items.size()).isEqualTo(3);
    }

    @Test
    @Transactional
    public void findSpecificItem() {
        Item item = itemDao.findItemByID(1L);
        assertThat(item.getPrice()).isEqualTo(80f);
        assertThat(item.getComposition()).isEqualTo("100% Coton");
    }

}