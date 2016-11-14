package edu.nju.rms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

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
		String hql = "delete from RiskItem where id='" + id + "'";
		Query query = baseDao.getSession().createQuery(hql);
		int result = query.executeUpdate();
		if(result > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateRiskItem(RiskItem item) {
		String hql = "update RiskItem set title='" + item.getTitle()  + 
					"', content='" + item.getContent() + 
					"', levelChance="	+ item.getLevelChance() + 
					", levelInfluence=" + item.getLevelInfluence() + 
					", follwer_id=" +  item.getFollower().getId() + 
					" where id=" + item.getId();
		Query query = baseDao.getSession().createQuery(hql);
		int result = query.executeUpdate();
		if(result == 1)
			return true;
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

	@Override
	public int deleteRiskItems(String ids) {
		String hql = "delete RiskItem where id in (" + ids + ")";
		Session session = baseDao.getSession();
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		return result;
	}

}
