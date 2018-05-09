package com.yonder.study.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yonder.study.model.TechLog;

@Repository
public class TechLogDAOImpl implements ITechLogDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public TechLog get(Long id) {
		return getCurrentSession().get(TechLog.class, id);
	}

	@Override
	public TechLog create(TechLog entity) {
		getCurrentSession().save(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TechLog> findAll() {
		return getCurrentSession().createCriteria(TechLog.class).list();
	}

	@Override
	public TechLog update(TechLog entity) {
		getCurrentSession().save(entity);
		return entity;
	}

	@Override
	public void delete(TechLog entity) {
		if(entity != null)
			getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TechLog> getTechLogForEmployee(long employeeId) {
		return (List<TechLog>) getCurrentSession()
			    .createQuery("Select o from TechLog o where o.employee.id = :myId")
			    .setParameter("myId", employeeId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TechLog> getTechLogForTechnology(long technologyId) {
		return (List<TechLog>) getCurrentSession()
			    .createQuery("Select o from TechLog o where o.technology.id = :myId")
			    .setParameter("myId", technologyId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TechLog> getTechLog(long employeeId, long technologyId) {
		return (List<TechLog>) getCurrentSession()
			    .createQuery("Select o from TechLog o where o.employee.id = :employeeId "
			    		+ "and o.technology.id = :technologyId")
			    .setParameter("technologyId", technologyId)
			    .setParameter("employeeId", employeeId).list();
	}

}
