package edu.nju.rms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="risk_trigger")
public class RiskTrigger {

	private int id;

	private String content;
	
	private RiskItem item;
	
	public RiskTrigger() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="item_id")
	public RiskItem getItem() {
		return item;
	}

	public void setItem(RiskItem item) {
		this.item = item;
	}
	
	
	
}
