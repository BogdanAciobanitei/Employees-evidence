package com.yonder.study.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yonder.study.model.Employee;
import com.yonder.study.model.Team;
import com.yonder.study.model.TeamEmployee;
import com.yonder.study.model.TechLog;

@Repository
public class TeamEmployeeDAOImpl implements ITeamEmployeeDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public TeamEmployee get(Long id) {
		return getCurrentSession().get(TeamEmployee.class, id);
	}

	@Override
	public TeamEmployee create(TeamEmployee entity) {
		getCurrentSession().save(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeamEmployee> findAll() {
		return getCurrentSession().createCriteria(TeamEmployee.class).list();
	}

	@Override
	public TeamEmployee update(TeamEmployee entity) {
		getCurrentSession().save(entity);
		return entity;
	}

	@Override
	public void delete(TeamEmployee entity) {
		if(entity != null)
			getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeamEmployee> getTeamsForEmployee(long employeeId) {
		return (List<TeamEmployee>) getCurrentSession()
			    .createQuery("Select o from TeamEmployee o where o.employee. = :employeeId")
			    .setParameter("employeeId", employeeId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeamEmployee> getEmployeesForTeam(long teamId) {
		return (List<TeamEmployee>) getCurrentSession()
			    .createQuery("Select o from TeamEmployee o where o.team.id = :teamId")
			    .setParameter("teamId", teamId).list();
	}

}
