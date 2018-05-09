package com.yonder.study.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yonder.study.model.Technology;

@Repository
public class TechnologyDAOImpl implements ITechnologyDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Technology get(Long id) {
		return getCurrentSession().get(Technology.class, id);
	}

	@Override
	public Technology create(Technology entity) {
		getCurrentSession().save(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Technology> findAll() {
		return getCurrentSession().createCriteria(Technology.class).list();
	}

	@Override
	public Technology update(Technology entity) {
		getCurrentSession().update(entity);
		return entity;
	}

	@Override
	public void delete(Technology entity) {
		if(entity != null)
			getCurrentSession().delete(entity);
	}

}
