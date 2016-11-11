package edu.nju.rms.dao;

import edu.nju.rms.model.RiskTrigger;

public interface RiskTriggerDao {
	
	public boolean addRiskTrigger(RiskTrigger trigger);

	public boolean deleteRiskTriggerById(int id);
	
	public boolean updateRiskTrigger(RiskTrigger trigger);
	
	public RiskTrigger getRiskTriggerById(int id);
}
