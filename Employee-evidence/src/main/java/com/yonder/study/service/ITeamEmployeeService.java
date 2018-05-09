package com.yonder.study.service;

import java.util.List;

import com.yonder.study.base.AbstractService;
import com.yonder.study.model.TeamEmployee;

public interface ITeamEmployeeService extends AbstractService<TeamEmployee>{
	
	public List<TeamEmployee> getTeamsForEmployee(long employeeId);
	
	public List<TeamEmployee> getEmployeesForTeam(long teamId);
	
}
