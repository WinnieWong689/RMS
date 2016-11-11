package edu.nju.rms.dao;

import edu.nju.rms.model.TriggerGroup;

public class TriggerGroupDaoImpl implements TriggerGroupDao {

	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public boolean addTriggerGroup(TriggerGroup group) {
		return this.baseDao.save(group);
	}

	@Override
	public boolean deleteTriggerGroupById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTriggerGroup(TriggerGroup group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TriggerGroup getTriggerGroupById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
