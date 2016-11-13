package edu.nju.rms.service;

import java.util.List;

import edu.nju.rms.model.User;

public interface UserService {
	
	public boolean updateUser(String nickname, String password, int role);
	
	public int addUser(String username, String nickname, String password, int role);

	public User getUser(int uid);
	
	public User check(String username, String password);

	public List<User> getAllUsers();

	public boolean deleteUsers(String ids);
	
	public boolean isExist(String username);

	public List<User> search(String username, String nickname, int role);

	public int getRole(int id);
	
}
