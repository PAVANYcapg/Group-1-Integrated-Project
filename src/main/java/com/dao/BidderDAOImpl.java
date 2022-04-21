package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Bidder;

@Component
public class BidderDAOImpl implements BidderDAO{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addTeam(Bidder team) {
		// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(team);
			session.flush();
			session.getTransaction().commit();
			session.close();
		
	}

	@Override
	public Bidder findteam(int id) {
			Session session = sessionFactory.openSession();
			Bidder bidder = session.get(Bidder.class, id); 
			return bidder;
	}

	@Override
	public List<Bidder> findAllTeam() {
		// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			List<Bidder> bidder=session.createQuery("select i from Bidder i").list();
			return bidder;
	}

	@Override
	public boolean updateTeam(Bidder team) {
		// TODO Auto-generated method stub
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
			session.getTransaction().begin();
			Bidder bidder=session.find(Bidder.class,id);
			session.delete(bidder);
			session.flush();
			session.getTransaction().commit();
			session.close();
			return true;
	}
}
