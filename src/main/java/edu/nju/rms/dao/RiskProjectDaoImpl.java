package edu.nju.rms.dao;

import java.util.List;

import javax.transaction.Transactional;

import edu.nju.rms.model.RiskProject;

public class RiskProjectDaoImpl implements RiskProjectDao {

	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<RiskProject> getAllRiskProject() {
		return baseDao.getAllList(RiskProject.class);
	}

	@Transactional
	@Override
	public boolean addRiskProject(RiskProject project) {
		return  baseDao.save(project);
	}

}
