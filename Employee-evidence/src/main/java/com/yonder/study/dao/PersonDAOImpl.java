package com.yonder.study.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yonder.study.model.Person;

@Repository
public class PersonDAOImpl implements IPersonDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Person get(Long id) {
		return getCurrentSession().get(Person.class, id);
	}

	@Override
	public Person create(Person entity) {
		getCurrentSession().save(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findAll() {
		return getCurrentSession().createCriteria(Person.class).list();
	}

	@Override
	public Person update(Person entity) {
		getCurrentSession().update(entity);
		return entity;
	}

	@Override
	public void delete(Person entity) {
		if(entity != null)
			getCurrentSession().delete(entity);
	}

}
