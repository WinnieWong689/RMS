package edu.nju.rms.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="risk_item")
public class RiskItem {

	private int id;
	
	private String title;
	
	private String content;
	
	private int uploader;
	
	private String latestCondition;
	
	private int levelInfluence;
	
	private int levelChance;
	
	private Date ctime;
	
	private Set<TriggerGroup> triggerGroups;
	
	private Set<User> followers;
	
	public RiskItem() {}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUploader() {
		return uploader;
	}

	public void setUploader(int uploader) {
		this.uploader = uploader;
	}

	@Column(name="latest_condition")
	public String getLatestCondition() {
		return latestCondition;
	}

	public void setLatestCondition(String latestCondition) {
		this.latestCondition = latestCondition;
	}

	@Column(name="level_influence")
	public int getLevelInfluence() {
		return levelInfluence;
	}

	public void setLevelInfluence(int levelInfluence) {
		this.levelInfluence = levelInfluence;
	}

	@Column(name="level_chance")
	public int getLevelChance() {
		return levelChance;
	}

	public void setLevelChance(int levelChance) {
		this.levelChance = levelChance;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	@OneToMany
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<TriggerGroup> getTriggerGroups() {
		return triggerGroups;
	}

	public void setTriggerGroups(Set<TriggerGroup> triggerGroups) {
		this.triggerGroups = triggerGroups;
	}

	@ManyToMany
	@JoinTable(
			name="risk_follower", 
			joinColumns={@JoinColumn(name="item_id")},
			inverseJoinColumns= {@JoinColumn(name="user_id")})
	public Set<User> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}
	
	
	
}
