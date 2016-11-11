package edu.nju.rms.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="trigger_group")
public class TriggerGroup {

	private int id;
	
	private String name;
	
	private Set<RiskTrigger> triggers;
	
	private RiskItem riskItem;
	
	public TriggerGroup() {}

	@Id
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

	@OneToMany
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<RiskTrigger> getTriggers() {
		return triggers;
	}

	public void setTriggers(Set<RiskTrigger> triggers) {
		this.triggers = triggers;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public RiskItem getRiskItem() {
		return riskItem;
	}

	public void setRiskItem(RiskItem riskItem) {
		this.riskItem = riskItem;
	}
	
}
