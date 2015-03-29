package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Item;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = {"classpath:test-jpa-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemDaoTest {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        itemDao.setSession(sessionFactory.openSession());
    }

    @Test
    public void findAllItems() {
        Item item = new Item();
        item.setComposition("test");
        item.setDescription("test");
        item.setPrice(123.45f);
        item.setReference(1);
        item = itemDao.saveItem(item);
        List<Item> items = itemDao.findAllItems();
        assertThat(items).isNotEmpty();
    }

}