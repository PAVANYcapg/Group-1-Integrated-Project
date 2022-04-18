package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Team;

@Component
public class TeamDAOImpl implements TeamDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addTeam(Team team) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(team);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Team findteam(int id) {
		Session session = sessionFactory.openSession();
		Team team = session.get(Team.class, id); 
		return team;
	}

	@Override
	public List<Team> findAllTeam() {
		Session session = sessionFactory.openSession();
		List<Team> leaderboard=session.createQuery("select i from Team i").list();
		return leaderboard;
	}

	@Override
	public boolean updateTeam(Team team) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(team);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteTeam(int id) {
		Session session = sessionFactory.openSession();
		Team team = session.find(Team.class, id);
		session.getTransaction().begin();
		session.delete(team);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}
	
	
}