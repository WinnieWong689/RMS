package edu.nju.rms.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	private User uploader;
	
	private String latestCondition;
	
	private int levelInfluence;
	
	private int levelChance;
	
	private Date ctime;
	
	private RiskProject project;
	
	private Set<RiskTrigger> triggers;
	
	private Set<TrackItem> trackItems;
	
	private User follower;
	
	public RiskItem() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@OneToMany(mappedBy="item")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<RiskTrigger> getTriggers() {
		return triggers;
	}

	public void setTriggers(Set<RiskTrigger> triggers) {
		this.triggers = triggers;
	}

	@ManyToOne
	@JoinColumn(name="follwer_id")
	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower= follower;
	}

	@ManyToOne
	@JoinColumn(name="uploader")
	public User getUploader() {
		return uploader;
	}

	public void setUploader(User uploader) {
		this.uploader = uploader;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id")
	public RiskProject getProject() {
		return project;
	}

	public void setProject(RiskProject project) {
		this.project = project;
	}

	@OneToMany(mappedBy="item")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<TrackItem> getTrackItems() {
		return trackItems;
	}

	public void setTrackItems(Set<TrackItem> trackItems) {
		this.trackItems = trackItems;
	}
	
	
	
}
