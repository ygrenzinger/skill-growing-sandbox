package com.carbon.ecommerce.dao;

import com.carbon.ecommerce.domain.Team;
import org.hibernate.Query;

import java.util.List;

public class TeamDao extends SuperDAO {

    public Team find(Long id) {
        Query query = createQuery("from Team where id = :id");
        query.setLong("id", id);
        return (Team) query.uniqueResult();
    }

    public List<Team> findAllTeams() {
        Query query = createQuery("from Team");
        return (List<Team>) query.list();
    }

    public Team saveTeam(Team team) {
        return (Team) merge(team);
    }
}
