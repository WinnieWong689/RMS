package edu.nju.rms.dao;

import java.util.List;

import org.hibernate.Query;

import edu.nju.rms.model.TrackItem;

public class TrackItemDaoImpl implements TrackItemDao {
	
	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public int addTrackItem(TrackItem item) {
		boolean result = baseDao.save(item);
		if (result) {
			return item.getId();
		} else {
			return -1;
		}
	}

	@Override
	public List<TrackItem> getTrackItemsByRiskId(int id) {
		String hql = "from TrackItem where item_id = " + id + " order by ctime desc";
		Query query = baseDao.getSession().createQuery(hql);
		List<TrackItem> list = query.list();
		return list;
	}

}
