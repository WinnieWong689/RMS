package edu.nju.rms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.nju.rms.dao.RiskItemDao;
import edu.nju.rms.dao.RiskTriggerDao;
import edu.nju.rms.dao.TrackItemDao;
import edu.nju.rms.model.RiskItem;
import edu.nju.rms.model.RiskTrigger;
import edu.nju.rms.model.TrackItem;

public class RiskServiceImpl implements RiskService {
	
	private RiskItemDao riskItemDao;
	
	private TrackItemDao trackItemDao;
	
	private RiskTriggerDao triggerDao;
	
	public void setTriggerDao(RiskTriggerDao triggerDao) {
		this.triggerDao = triggerDao;
	}
	
	public void setRiskItemDao(RiskItemDao riskItemDao) {
		this.riskItemDao = riskItemDao;
	}

	public void setTrackItemDao(TrackItemDao trackItemDao) {
		this.trackItemDao = trackItemDao;
	}
	
    public boolean addRiskItem(RiskItem item) {
    	boolean result = riskItemDao.addRiskItem(item);
    	if(result) {
	    	List<RiskTrigger> triggerList = new ArrayList<RiskTrigger>(item.getTriggers());
	    	for(int i=0; i<triggerList.size(); i++) {
	    		RiskTrigger trigger = triggerList.get(i);
	    		trigger.setItem(item);
	    		result = triggerDao.addRiskTrigger(triggerList.get(i));
	    	}
    	}
    	return result;
    }


    public boolean deleteRiskItemById(int id) {
        // TODO Auto-generated method stub
        return false;
    }


    public boolean updateRiskItem(RiskItem item) {
        return riskItemDao.updateRiskItem(item);
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
		return trackItemDao.addTrackItem(track);
	}

	@Override
	public List<TrackItem> getTrackItemByRiskItemId(int riskId) {
		return trackItemDao.getTrackItemsByRiskId(riskId);
	}

	@Override
	public boolean deleteRisks(String ids) {
		int result = riskItemDao.deleteRiskItems(ids);
		String[] arr = ids.split(",");
		if (result == arr.length) {
			return true;
		} else {
			return false;
		}
	}

}
