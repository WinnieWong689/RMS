package edu.nju.rms.service;

import java.util.Date;
import java.util.List;

import edu.nju.rms.dao.RiskItemDao;
import edu.nju.rms.dao.RiskProjectDao;
import edu.nju.rms.model.RiskItem;
import edu.nju.rms.model.RiskProject;

public class RiskServiceImpl implements RiskService {

	private RiskItemDao riskItemDao;
	
	public void setRiskItemDao(RiskItemDao riskItemDao) {
		this.riskItemDao = riskItemDao;
	}

    public boolean addRiskItem(RiskItem item) {
        return riskItemDao.addRiskItem(item);
    }


    public boolean deleteRiskItemById(int id) {
        // TODO Auto-generated method stub
        return false;
    }


    public boolean updateRiskItem(RiskItem item) {
        // TODO Auto-generated method stub
        return false;
    }


    public RiskItem getRiskItemById(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    public List<RiskItem> getRiskItemByProjectId(int projectId) {
        // TODO Auto-generated method stub
        return null;
    }
}
