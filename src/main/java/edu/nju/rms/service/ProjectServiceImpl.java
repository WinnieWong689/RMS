package edu.nju.rms.service;

import java.util.Date;
import java.util.List;

import edu.nju.rms.dao.RiskProjectDao;
import edu.nju.rms.model.RiskProject;

public class ProjectServiceImpl implements ProjectService {

	private RiskProjectDao riskProjectDao;
	
	public void setRiskProjectDao(RiskProjectDao riskProjectDao) {
		this.riskProjectDao = riskProjectDao;
	}
	
	public List<RiskProject> getAllRiskProject() {
		return riskProjectDao.getAllRiskProject();
	}

	public boolean addRiskProject(String name, String desc, int createrId) {
		RiskProject rp = new RiskProject();
		rp.setName(name);
		rp.setDescription(desc);
		rp.setCreater(createrId);
		rp.setCtime(new Date());
		return riskProjectDao.addRiskProject(rp);
	}

	@Override
	public RiskProject getProjectById(int projectId) {
		return riskProjectDao.getProjectById(projectId);
	}

	@Override
	public boolean updateProject(String name, String description, Integer id) {
		return riskProjectDao.updateProject(name, description, id);
	}

}
