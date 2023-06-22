package com.phase.Phase3Project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Centers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String city;
	private String center;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
		return "Centers [id=" + id + ", city=" + city + ", center=" + center + "]";
	}
	public Centers(String city, String center) {
		super();
		this.city = city;
		this.center = center;
	}
	
	public Centers() {
		
	}
	
	
}
