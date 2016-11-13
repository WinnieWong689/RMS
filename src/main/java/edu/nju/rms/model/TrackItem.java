package edu.nju.rms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="track_item")
public class TrackItem {

	private int id;
	
	private RiskItem item;
	
	private String title;
	
	private String description;
	
	private Date ctime;
	
	public TrackItem() {}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	@ManyToOne
	@JoinColumn(name="item_id")
	public RiskItem getItem() {
		return item;
	}
	
	public void setItem(RiskItem item) {
		this.item = item;
	}
	
	
}
