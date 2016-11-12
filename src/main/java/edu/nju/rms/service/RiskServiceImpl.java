package edu.nju.rms.service;

import java.util.Date;
import java.util.List;

import edu.nju.rms.dao.RiskProjectDao;
import edu.nju.rms.model.RiskProject;

public class RiskServiceImpl implements RiskService {

	private RiskProjectDao riskProjectDao;
	
	public void setRiskProjectDao(RiskProjectDao riskProjectDao) {
		this.riskProjectDao = riskProjectDao;
	}
	
	public List<RiskProject> getAllRiskProject() {
		return riskProjectDao.getAllRiskProject();
	}

	@Override
	public boolean addRiskProject(String name, String desc, int createrId) {
		RiskProject rp = new RiskProject();
		rp.setName(name);
		rp.setDescription(desc);
		rp.setCreater(createrId);
		rp.setCtime(new Date());
		return riskProjectDao.addRiskProject(rp);
	}

}
