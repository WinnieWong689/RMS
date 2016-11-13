package edu.nju.rms.service;

import java.util.List;

import edu.nju.rms.dao.UserDao;
import edu.nju.rms.model.User;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
		
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}

	@Override
	public User getUser(int uid) {
		return userDao.getUser(uid);
	}

	@Override
	public User check(String username, String password) {
		if (username == null || password == null) {
			return null;
		}
		return userDao.check(username, password);
	}

	@Override
	public boolean updateUser(String nickname, String password, int role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addUser(String username, String nickname, String password, int role) {
		User user = new User();
		user.setUsername(username);
		user.setNickname(nickname);
		user.setPassword(password);
		user.setRole(role);
		return this.userDao.addUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return this.userDao.getAllUser();
	}

	@Override
	public boolean deleteUsers(String ids) {
		int result = userDao.deleteUsers(ids);
		String[] idArr = ids.split(",");
		return result == idArr.length;
	}

	@Override
	public boolean isExist(String username) {
		return userDao.isExist(username);
	}

	@Override
	public List<User> search(String username, String nickname, int role) {
		return userDao.search(username, nickname, role);
	}

}
