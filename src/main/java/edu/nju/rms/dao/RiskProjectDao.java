package edu.nju.rms.dao;

import java.util.List;

import edu.nju.rms.model.RiskProject;

public interface RiskProjectDao {
	
	public boolean addRiskProject(RiskProject project);

	public List<RiskProject> getAllRiskProject();
	
}
