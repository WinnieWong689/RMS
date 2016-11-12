package edu.nju.rms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.nju.rms.model.User;

public class UserDaoImpl implements UserDao {
	
	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public int addUser(User user) {
		boolean result = baseDao.save(user);
		if (result) {
			return user.getId();
		} else {
			return -1;
		}
	}

	public boolean deleteUser(int uid) {
		return false;
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUser(int uid) {
		String hql = "from User where id=" + uid;
		Query query = baseDao.getSession().createQuery(hql);
		List<User> list = query.list();
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	public List<User> getAllUser() {
		String hql = "from User where username != 'admin'";
		Query query = baseDao.getSession().createQuery(hql);
		List<User> list = query.list();
		return list;
	}

	public User check(String username, String password) {
		String hql = "from User where username='" + username +"' and password='" + password + "'";
		Session session = baseDao.getSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("rawtypes")
		List result = query.list();
		if(result.isEmpty())
			return null;
		User user = (User)result.get(0);
		return user;
	}

}
