package com.yonder.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yonder.study.model.Employee;
import com.yonder.study.model.Team;
import com.yonder.study.model.TeamEmployee;
import com.yonder.study.service.ITeamEmployeeService;

@RestController
@RequestMapping(path = "/team-employee")
public class TeamEmployeeController {
	
	@Autowired
	ITeamEmployeeService service;
	
	@RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<TeamEmployee> getTeamEmployee(@PathVariable long id) {
		TeamEmployee teamEmployee = service.get(id);
		if(teamEmployee != null)
			return new ResponseEntity<TeamEmployee>(teamEmployee, HttpStatus.OK);
		else
			return new ResponseEntity<TeamEmployee>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<TeamEmployee>> getTeamsForEmployee(@PathVariable long id) {
		List<TeamEmployee> teamEmployee = service.getTeamsForEmployee(id);
		return new ResponseEntity<List<TeamEmployee>>(teamEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/team/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<TeamEmployee>> getEmployeesForTeam(@PathVariable long id) {
		List<TeamEmployee> teamEmployees = service.getEmployeesForTeam(id);
		return new ResponseEntity<List<TeamEmployee>>(teamEmployees, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<TeamEmployee>> getTeamEmployees() {
		List<TeamEmployee> teamEmployee = service.findAll();
		return new ResponseEntity<List<TeamEmployee>>(teamEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public ResponseEntity<TeamEmployee> createTeamEmployee(@RequestBody TeamEmployee teamEmployee) {
		
		teamEmployee = service.create(teamEmployee);
		if(teamEmployee != null)
			return new ResponseEntity<TeamEmployee>(teamEmployee, HttpStatus.CREATED);
		else
			return new ResponseEntity<TeamEmployee>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TeamEmployee> updateTeamEmployee(@RequestBody TeamEmployee teamEmployee, @PathVariable long id) {
		
		TeamEmployee currentTeamEmployee;
		currentTeamEmployee = service.get(id);
		if(currentTeamEmployee == null)
			return new ResponseEntity<TeamEmployee>(HttpStatus.NOT_FOUND);
		
		currentTeamEmployee.setEmployee(teamEmployee.getEmployee());
		currentTeamEmployee.setTeam(teamEmployee.getTeam());
		currentTeamEmployee.setDate(teamEmployee.getDate());
		service.update(currentTeamEmployee);
		
		return new ResponseEntity<TeamEmployee>(currentTeamEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TeamEmployee> createTeamEmployee(@PathVariable long id) {
		TeamEmployee teamEmployee = service.get(id);
		if(teamEmployee == null){
			return new ResponseEntity<TeamEmployee>(HttpStatus.NOT_FOUND);
		}
		else{
			service.delete(teamEmployee);
			return new ResponseEntity<TeamEmployee>(HttpStatus.OK);
		}
	}
	
}
