package edu.nju.rms.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	private int id;
	
	private String username;
	
	private String nickname;
	
	private int role;
	
	private String password;
	
	private Set<RiskProject> projects;
	
	public User() {}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@ManyToMany(mappedBy="members")
	public Set<RiskProject> getProjects() {
		return projects;
	}

	public void setProjects(Set<RiskProject> projects) {
		this.projects = projects;
	}
	
	
	
}
