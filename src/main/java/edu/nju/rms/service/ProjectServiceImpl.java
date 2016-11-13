package edu.nju.rms.service;

import edu.nju.rms.dao.RiskProjectDao;
import edu.nju.rms.model.RiskProject;

import java.util.Date;
import java.util.List;

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

}
