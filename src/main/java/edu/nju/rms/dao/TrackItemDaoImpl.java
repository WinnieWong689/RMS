package edu.nju.rms.dao;

public class TrackItemDaoImpl implements TrackItemDao {
	
	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public int addTrackItem(TrackItem item) {
		boolean result = baseDao.save(item);
		if (result) {
			return user.getId();
		} else {
			return -1;
		}
	}
}
