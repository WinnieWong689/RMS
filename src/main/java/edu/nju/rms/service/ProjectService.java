package edu.nju.rms.service;

import edu.nju.rms.model.RiskProject;

import java.util.List;

public interface ProjectService {
	
	public boolean addRiskProject(String name, String desc, int createrId);
	
	public List<RiskProject> getAllRiskProject();

	public RiskProject getProjectById(int projectId);

	public boolean updateProject(String name, String description, Integer uid);
	
}
