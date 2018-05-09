package com.yonder.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yonder.study.dao.ITechnologyDAO;
import com.yonder.study.model.Technology;

@Service("technologyService")
@Transactional(rollbackFor = Exception.class)
public class TechnologyServiceImpl implements ITechnologyService{
	
	@Autowired
	private ITechnologyDAO TechnologyDAO;
	
	@Override
	public Technology get(Long id) {
		return TechnologyDAO.get(id);
	}

	@Override
	public Technology create(Technology entity) {
		return TechnologyDAO.create(entity);
	}

	@Override
	public List<Technology> findAll() {
		return TechnologyDAO.findAll();
	}

	@Override
	public Technology update(Technology entity) {
		return TechnologyDAO.update(entity);
	}

	@Override
	public void delete(Technology entity) {
		TechnologyDAO.delete(entity);
		
	}
}
