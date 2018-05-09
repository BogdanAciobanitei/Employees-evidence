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

import com.yonder.study.model.Team;
import com.yonder.study.service.ITeamService;

@RestController
@RequestMapping(path = "/team")
public class TeamController {

	@Autowired
	ITeamService service;
	
	@RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Team> getTeam(@PathVariable long id) {
		Team team = service.get(id);
		if(team != null)
			return new ResponseEntity<Team>(team, HttpStatus.OK);
		else
			return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Team>> getTeams() {
		List<Team> teams = service.findAll();
		return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public ResponseEntity<Team> createTeam(@RequestBody Team team) {
		
		team = service.create(team);
		if(team != null)
			return new ResponseEntity<Team>(team, HttpStatus.CREATED);
		else
			return new ResponseEntity<Team>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Team> updateTeam(@RequestBody Team team, @PathVariable long id) {
		
		Team currentTeam;
		currentTeam = service.get(id);
		if(currentTeam == null)
			return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
		currentTeam.setName(team.getName());
		currentTeam.setNbOfMembers(team.getNbOfMembers());
		service.update(currentTeam);
		
		return new ResponseEntity<Team>(currentTeam, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Team> deleteTeam(@PathVariable long id) {
		Team team = service.get(id);
		if(team == null){
			return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
		}
		else{
			service.delete(team);
			return new ResponseEntity<Team>(HttpStatus.OK);
		}
	}

}
