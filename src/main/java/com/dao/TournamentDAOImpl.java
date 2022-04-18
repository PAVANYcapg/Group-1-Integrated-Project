package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Tournaments;

@Component
public class TournamentDAOImpl implements TournamentDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addTeam(Tournaments team) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(team);
		session.flush();
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public Tournaments findteam(int id) {
		Session session = sessionFactory.openSession();
		Tournaments team = session.get(Tournaments.class, id); 
		return team;
	}
	@Override
	public List<Tournaments> findAllTeam() {
		Session session = sessionFactory.openSession();
		List<Tournaments> teamlist=session.createQuery("select i from Tournaments i").list();
		return teamlist;
	}
	@Override
	public boolean updateTeam(Tournaments team) {
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
		Tournaments tournaments=session.find(Tournaments.class, id);
		session.getTransaction().begin();
		session.delete(tournaments);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

}
