package com.yonder.study.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yonder.study.model.Team;

@Repository
public class TeamDAOImpl implements ITeamDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Team get(Long id) {
		return getCurrentSession().get(Team.class, id);
	}

	@Override
	public Team create(Team entity) {
		getCurrentSession().save(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> findAll() {
		return getCurrentSession().createCriteria(Team.class).list();
	}

	@Override
	public Team update(Team entity) {
		getCurrentSession().update(entity);
		return entity;
	}

	@Override
	public void delete(Team entity) {
		if(entity != null)
			getCurrentSession().delete(entity);
	}

}
