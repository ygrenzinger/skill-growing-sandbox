package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.Stock;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = {"classpath:test-jpa-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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
    public void saveItem() {
        Item item = new Item();
        item.setComposition("test");
        item.setDescription("test");
        item.setPrice(123.45f);
        item.setReference(1);
        Item savedItem = itemDao.saveItem(item);
        assertThat(savedItem.getId()).isPositive();
        assertThat(savedItem.getPrice()).isEqualTo(item.getPrice());
        assertThat(savedItem.getReference()).isEqualTo(item.getReference());
        assertThat(savedItem.getComposition()).isEqualTo(item.getComposition());
        assertThat(savedItem.getDescription()).isEqualTo(item.getDescription());
    }

    @Test
    public void findAllItems() {
        List<Item> items = itemDao.findAllItems();
        assertThat(items).isNotEmpty();
        assertThat(items.size()).isEqualTo(3);
    }

    @Test
    public void findSpecificItem() {
        List<Item> items = itemDao.findItemByID(1);
        assertThat(items).isNotEmpty();
        assertThat(items.size()).isEqualTo(1);
        assertThat(items.get(0).getPrice()).isEqualTo(80f);
        assertThat(items.get(0).getComposition()).isEqualTo("100% Coton");
    }

}