package edu.nju.rms.dao;

import java.util.List;

import edu.nju.rms.model.RiskItem;

public class RiskItemDaoImpl implements RiskItemDao {

	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public boolean addRiskItem(RiskItem item) {
		return baseDao.save(item);
	}

	@Override
	public boolean deleteRiskItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRiskItem(RiskItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RiskItem getRiskItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskItem> getRiskItemByProjectId(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}

}
