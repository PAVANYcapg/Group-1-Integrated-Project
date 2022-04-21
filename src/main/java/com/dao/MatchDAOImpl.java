package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Match;

@Component
public class MatchDAOImpl implements MatchDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addTeam(Match match) {
		// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(match);
			session.flush();
			session.getTransaction().commit();
			session.close();
		
	}

	@Override
	public Match findteam(int id) {
			Session session = sessionFactory.openSession();
			Match match = session.get(Match.class, id); 
			return match;
	}

	@Override
	public List<Match> findAllTeam() {
		// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			List<Match> match=session.createQuery("select i from Match i").list();
			return match;
	}

	@Override
	public boolean updateTeam(Match match) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(match);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteTeam(int id) {
			Session session = sessionFactory.openSession();
			Match match=session.find(Match.class, id);
			session.getTransaction().begin();
			session.delete(match);
			session.flush();
			session.getTransaction().commit();
			session.close();
			return true;
	}
	
	
}
