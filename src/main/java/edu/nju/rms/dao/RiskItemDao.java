package edu.nju.rms.dao;

import java.util.List;

import edu.nju.rms.model.RiskItem;

public interface RiskItemDao {

	public boolean addRiskItem(RiskItem item);

	public boolean deleteRiskItemById(int id);
	
	public boolean updateRiskItem(RiskItem item);
	
	public RiskItem getRiskItemById(int id);
	
	public List<RiskItem> getRiskItemByProjectId(int projectId);

	public int deleteRiskItems(String ids);
	

}
