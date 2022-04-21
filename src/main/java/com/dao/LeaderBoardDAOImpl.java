package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.LeaderBoard;

@Component
public class LeaderBoardDAOImpl implements LeaderBoardDAO{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addTeam(LeaderBoard team) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(team);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public LeaderBoard findteam(int id) {
		Session session = sessionFactory.openSession();
		LeaderBoard leaderboard = session.get(LeaderBoard.class, id); 
		return leaderboard;
	}

	@Override
	public List<LeaderBoard> findAllTeam() {
		Session session = sessionFactory.openSession();
		List<LeaderBoard> leaderboard=session.createQuery("select i from LeaderBoard i").list();
		return leaderboard;
	}

	@Override
	public boolean updateTeam(LeaderBoard team) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(team);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteTeam(int  id) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		LeaderBoard leaderBoard=session.find(LeaderBoard.class,id);
		session.delete(leaderBoard);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}
}
