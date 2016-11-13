package edu.nju.rms.dao;

import java.util.List;

import org.hibernate.Query;

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
		String hql = "from RiskItem where id=" + id;
		Query query = baseDao.getSession().createQuery(hql);
		List<RiskItem> list = query.list();
		if(!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<RiskItem> getRiskItemByProjectId(int projectId) {
		String hql = "from RiskItem where project_id=" + projectId;
		Query query = baseDao.getSession().createQuery(hql);
		List<RiskItem> list = query.list();
		return list;
	}

}
