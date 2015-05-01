package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Team;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = {"classpath:test-jpa-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
public class TeamDaoTest {

    @Autowired
    private TeamDao teamDao;

    @Test
    @Transactional
    public void findAllCategories() throws Exception {
        List<Team> teamList = teamDao.findAllTeams();
        assertThat(teamList.size()).isEqualTo(1);
        assertThat(teamList.get(0).getName()).isEqualTo("Bordeaux");
        assertThat(teamList.get(0).getItems().size()).isEqualTo(3);
    }

    @Test
    @Transactional
    public void saveCategory() throws Exception {
        Team team = new Team();
        team.setName("test");
        team.addItem(TestsFactory.createItem());
        Team savedTeam = teamDao.saveTeam(team);
        assertThat(savedTeam.getId()).isPositive();
        assertThat(savedTeam.getName()).isEqualTo("test");
        assertThat(savedTeam.getItems().size()).isEqualTo(1);
        assertThat(savedTeam.getItems().contains(TestsFactory.createItem()));
    }
}