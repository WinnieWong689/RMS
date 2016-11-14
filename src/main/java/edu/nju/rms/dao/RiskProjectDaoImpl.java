package edu.nju.rms.dao;

import java.util.List;

import javax.transaction.Transactional;

import edu.nju.rms.model.RiskProject;
import edu.nju.rms.model.User;
import org.hibernate.Query;

public class RiskProjectDaoImpl implements RiskProjectDao {

	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<RiskProject> getAllRiskProject() {
		String hql = "from RiskProject";
		Query query = baseDao.getSession().createQuery(hql);
		List<RiskProject> list = query.list();
		return list;
	}

	@Transactional
	@Override
	public boolean addRiskProject(RiskProject project) {
		return  baseDao.save(project);
	}

	@Override
	public RiskProject getProjectById(int projectId) {
		String hql = "from RiskProject where id=" + projectId;
		Query query = baseDao.getSession().createQuery(hql);
		List<RiskProject> list = query.list();
		if(list.isEmpty())
			return null;
		return list.get(0);
	}

	@Override
	public boolean updateProject(String name, String description, Integer id) {
		String hql = "update RiskProject set name='" + name  + 
				"', description='" + description + 
				"' where id=" + id;
		Query query = baseDao.getSession().createQuery(hql);
		int result = query.executeUpdate();
		if(result == 1)
			return true;
		return false;
	}

}
