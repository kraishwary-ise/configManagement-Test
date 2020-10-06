package com.comviva.ConfigurationApp.response;

public class NameEmail {
	
	private String triggerName;
	private String email;
	private String name;
	
	
	NameEmail() {
		
	}


	public NameEmail(String triggerName, String email, String name) {
		this.triggerName = triggerName;
		this.email = email;
		this.name = name;
	}


	public String getTriggerName() {
		return triggerName;
	}


	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

}
