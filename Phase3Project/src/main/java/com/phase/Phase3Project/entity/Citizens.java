package com.phase.Phase3Project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Citizens {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String city;
	private String doses;
	private String status;
	private String center;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDoses() {
		return doses;
	}
	public void setDoses(String doses) {
		this.doses = doses;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Citizens [id=" + id + ", name=" + name + ", city=" + city + ", doses=" + doses + ", status=" + status
				+ ", center=" + center + "]";
	}
	public Citizens(String name, String city, String doses, String status, String center) {
		super();
		this.name = name;
		this.city = city;
		this.doses = doses;
		this.status = status;
		this.center = center;
	}
	
	public Citizens() {
		
	}
	
	
	
}
