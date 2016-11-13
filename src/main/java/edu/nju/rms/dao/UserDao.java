package edu.nju.rms.dao;

import java.util.List;

import edu.nju.rms.model.User;

public interface UserDao {
	
	public int addUser(User user);
		
	public boolean deleteUser(int uid);
	
	public boolean updateUser(User user);
	
	public User getUser(int uid);
	
	public List<User> getAllUser();
	
	public User check(String username, String password);

	public int deleteUsers(String ids);
	
	public boolean isExist(String username);

	public List<User> search(String username, String nickname, Integer role);

}
