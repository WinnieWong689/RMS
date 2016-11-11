package edu.nju.rms.dao;

import edu.nju.rms.model.RiskLevel;

public class RiskLevelDaoImpl implements RiskLevelDao {

	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public boolean addRiskLevel(RiskLevel level) {
		return baseDao.save(level);
	}

	@Override
	public boolean deleteRiskLevelById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRiskLevel(RiskLevel level) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RiskLevel getRiskLevelById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
