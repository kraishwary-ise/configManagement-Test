package com.comviva.ConfigurationApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usecase")
public class UseCase {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idusecase")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String desc;
	
	@Column(name="sdate")
	private String sdate;
	
	@Column(name="edate")
	private String edate;
	
	@Column(name="direction")
	private String direction;
	
	@Column(name="campeing")
	private String campeing;
	
	@Column(name="businesslogic")
	private String businesslog;
	
	
	@Column(name="email")
	private String userEmail;
	

	public UseCase() {
		
	}
	
	public UseCase(String name, String desc, String sdate, String edate, String direction,String campeing, String businesslog,String userEmail) {
		super();
		this.name = name;
		this.desc = desc;
		this.sdate = sdate;
		this.edate = edate;
		this.direction = direction;
		this.campeing = campeing;
		this.businesslog = businesslog;
		this.userEmail=userEmail;
	}
	
	
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getCampeing() {
		return campeing;
	}
	public void setCampeing(String campeing) {
		this.campeing = campeing;
	}
	public String getBusinesslog() {
		return businesslog;
	}
	public void setBusinesslog(String businesslog) {
		this.businesslog = businesslog;
	}
		
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "useCase [name=" + name + ", desc=" + desc + ", sdate=" + sdate + ", edate=" + edate + ", direction="
				+ direction + " , campeing=" + campeing
				+ ", businesslog=" + businesslog + "]";
	}
	
}
