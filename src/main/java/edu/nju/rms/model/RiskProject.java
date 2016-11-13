package edu.nju.rms.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="risk_project")
public class RiskProject {

	private int id;
	
	private String name;
	
	private int creater;
	
	private String description;
	
	private Date ctime;
	
	private Set<RiskItem> items;
	
	public RiskProject() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreater() {
		return creater;
	}

	public void setCreater(int creater) {
		this.creater = creater;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<RiskItem> getItems() {
		return items;
	}

	public void setItems(Set<RiskItem> items) {
		this.items = items;
	}	
	
}
