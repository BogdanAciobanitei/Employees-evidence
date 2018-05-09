package com.yonder.study.dao;

import java.util.List;

import com.yonder.study.base.AbstractDAO;
import com.yonder.study.model.TeamEmployee;

public interface ITeamEmployeeDAO extends AbstractDAO<TeamEmployee>{
	
	public List<TeamEmployee> getTeamsForEmployee(long employeeId);
	
	public List<TeamEmployee> getEmployeesForTeam(long teamId);
	
}
