package edu.nju.rms.dao;

import edu.nju.rms.model.RiskLevel;

public interface RiskLevelDao {
	
	public boolean addRiskLevel(RiskLevel level);

	public boolean deleteRiskLevelById(int id);
	
	public boolean updateRiskLevel(RiskLevel level);
	
	public RiskLevel getRiskLevelById(int id);
}
