package edu.nju.rms.service;

import java.util.Date;
import java.util.List;

import edu.nju.rms.dao.RiskItemDao;
import edu.nju.rms.dao.TrackItemDao;
import edu.nju.rms.model.RiskItem;
import edu.nju.rms.model.TrackItem;

public class RiskServiceImpl implements RiskService {
	
	private RiskItemDao riskItemDao;
	
	private TrackItemDao trackItemDao;
	
	public void setRiskItemDao(RiskItemDao riskItemDao) {
		this.riskItemDao = riskItemDao;
	}

	public void setTrackItemDao(TrackItemDao trackItemDao) {
		this.trackItemDao = trackItemDao;
	}
	
    public boolean addRiskItem(RiskItem item) {
        return riskItemDao.addRiskItem(item);
    }


    public boolean deleteRiskItemById(int id) {
        // TODO Auto-generated method stub
        return false;
    }


    public boolean updateRiskItem(RiskItem item) {
        // TODO Auto-generated method stub
        return false;
    }


    public RiskItem getRiskItemById(int id) {
        return this.riskItemDao.getRiskItemById(id);
    }
    
    public List<RiskItem> getRiskItemByProjectId(int projectId) {
        return riskItemDao.getRiskItemByProjectId(projectId);
    }
	
	@Override
	public int addTrackItem(int itemId, String title, String description){
		TrackItem track = new TrackItem();
		RiskItem item = riskItemDao.getRiskItemById(itemId);
		track.setItem(item);
		track.setTitle(title);
		track.setDescription(description);
		track.setCtime(new Date());
		System.out.println(item);
		return trackItemDao.addTrackItem(track);
	}

	@Override
	public List<TrackItem> getTrackItemByRiskItemId(int riskId) {
		return trackItemDao.getTrackItemsByRiskId(riskId);
	}

}
