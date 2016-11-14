package edu.nju.rms.service;

import java.util.List;

import edu.nju.rms.model.RiskItem;
import edu.nju.rms.model.TrackItem;

public interface RiskService {

	public boolean addRiskItem(RiskItem item);

	public boolean deleteRiskItemById(int id);

	public boolean updateRiskItem(RiskItem item);

	public RiskItem getRiskItemById(int id);

	public List<RiskItem> getRiskItemByProjectId(int projectId);
	
	public int addTrackItem(int itemId,String title,String description);
	
	public List<TrackItem> getTrackItemByRiskItemId(int riskId);

	public boolean deleteRisks(String ids);
}
