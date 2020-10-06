package com.comviva.ConfigurationApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="triggers")
public class Trigger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtrigger")
	private int id;
	
	
	@Column(name="usecaseid") 
	private int useCaseId;
	
	@Column(name="triggername")
	private String triggerName;
	
	Trigger() {
		
	}

	

	public Trigger(int useCaseId, String triggerName) {
		this.useCaseId = useCaseId;
		this.triggerName = triggerName;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUseCaseId() {
		return useCaseId;
	}

	public void setUseCaseId(int useCaseId) {
		this.useCaseId = useCaseId;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}


	

}
