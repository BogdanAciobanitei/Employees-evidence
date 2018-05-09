package com.yonder.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yonder.study.dao.ITeamEmployeeDAO;
import com.yonder.study.model.TeamEmployee;

@Service("teamEmployeeService")
@Transactional(rollbackFor = Exception.class)
public class TeamEmployeeServiceImpl implements ITeamEmployeeService {

	@Autowired
	private ITeamEmployeeDAO TeamEmployeeDAO;

	@Override
	public TeamEmployee get(Long id) {
		return TeamEmployeeDAO.get(id);
	}

	@Override
	public TeamEmployee create(TeamEmployee entity) {
		return TeamEmployeeDAO.create(entity);
	}

	@Override
	public List<TeamEmployee> findAll() {
		return TeamEmployeeDAO.findAll();
	}

	@Override
	public TeamEmployee update(TeamEmployee entity) {
		return TeamEmployeeDAO.update(entity);
	}

	@Override
	public void delete(TeamEmployee entity) {
		TeamEmployeeDAO.delete(entity);

	}

	@Override
	public List<TeamEmployee> getTeamsForEmployee(long employeeId) {
		return TeamEmployeeDAO.getTeamsForEmployee(employeeId);
	}

	@Override
	public List<TeamEmployee> getEmployeesForTeam(long teamId) {
		return TeamEmployeeDAO.getEmployeesForTeam(teamId);
	}

}
