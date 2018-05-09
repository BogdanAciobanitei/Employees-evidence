package com.yonder.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yonder.study.dao.ITechLogDAO;
import com.yonder.study.model.TechLog;

@Service("techLogService")
@Transactional(rollbackFor = Exception.class)
public class TechLogServiceImpl implements ITechLogService{

	@Autowired
	private ITechLogDAO TechLogDAO;
	
	@Override
	public TechLog get(Long id) {
		return TechLogDAO.get(id);
	}

	@Override
	public TechLog create(TechLog entity) {
		return TechLogDAO.create(entity);
	}

	@Override
	public List<TechLog> findAll() {
		return TechLogDAO.findAll();
	}

	@Override
	public TechLog update(TechLog entity) {
		return TechLogDAO.update(entity);
	}

	@Override
	public void delete(TechLog entity) {
		TechLogDAO.delete(entity);
		
	}

	@Override
	public List<TechLog> getTechLogForEmployee(long employeeId) {
		return TechLogDAO.getTechLogForEmployee(employeeId);
	}

	@Override
	public List<TechLog> getTechLogForTechnology(long technologyId) {
		return TechLogDAO.getTechLogForTechnology(technologyId);
	}

	@Override
	public List<TechLog> getTechLog(long employeeId, long technologyId) {
		return TechLogDAO.getTechLog(employeeId, technologyId);
	}
}
