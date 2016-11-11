package edu.nju.rms.dao;

import edu.nju.rms.model.RiskTrigger;

public class RiskTriggerDaoImpl implements RiskTriggerDao {

	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public boolean addRiskTrigger(RiskTrigger trigger) {
		return this.baseDao.save(trigger);
	}

	@Override
	public boolean deleteRiskTriggerById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRiskTrigger(RiskTrigger trigger) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RiskTrigger getRiskTriggerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
