package com.yonder.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yonder.study.dao.ITeamDAO;
import com.yonder.study.model.Team;

@Service("teamService")
@Transactional(rollbackFor = Exception.class)
public class TeamServiceImpl implements ITeamService{

	@Autowired
	private ITeamDAO TeamDAO;
	
	@Override
	public Team get(Long id) {
		return TeamDAO.get(id);
	}

	@Override
	public Team create(Team entity) {
		return TeamDAO.create(entity);
	}

	@Override
	public List<Team> findAll() {
		return TeamDAO.findAll();
	}

	@Override
	public Team update(Team entity) {
		return TeamDAO.update(entity);
	}

	@Override
	public void delete(Team entity) {
		TeamDAO.delete(entity);
		
	}
}
