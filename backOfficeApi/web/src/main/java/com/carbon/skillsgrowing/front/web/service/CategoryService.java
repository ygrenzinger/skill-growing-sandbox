package com.carbon.skillsgrowing.front.web.service;

import com.carbon.ecommerce.dao.TeamDao;
import com.carbon.ecommerce.domain.Team;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService extends SuperServiceImpl {

    private final static Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private TeamDao teamDao;

    @Inject
    public CategoryService(TeamDao teamDao, SessionFactory sessionFactory) {
        super(sessionFactory);
        this.teamDao = teamDao;
    }

    @Transactional
    public List<com.carbon.ecommerce.backoffice.api.Team> createCategories(List<Team> categories) {
        List<com.carbon.ecommerce.backoffice.api.Team> result = new ArrayList<>();
        Mapper mapper = new DozerBeanMapper();
        for (Team team : categories) {
            Team savedTeam = teamDao.saveTeam(team);
            com.carbon.ecommerce.backoffice.api.Team cat =
                    mapper.map(savedTeam, com.carbon.ecommerce.backoffice.api.Team.class);
            result.add(cat);
        }
        return result;
    }

    @Transactional
    public List<com.carbon.ecommerce.backoffice.api.Team> getCategories() {
        List<com.carbon.ecommerce.backoffice.api.Team> categoriesDto = new ArrayList<>();
        List<Team> categories = teamDao.findAllTeams();
        Mapper mapper = new DozerBeanMapper();
        for (Team team : categories) {
            categoriesDto.add(mapper.map(team, com.carbon.ecommerce.backoffice.api.Team.class));
        }
        return categoriesDto;
    }

    @Transactional
    public Team searchTeam(long teamId) {
        return teamDao.find(teamId);
    }
}
