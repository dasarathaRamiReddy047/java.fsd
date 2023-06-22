package com.phase.Phase3Project.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import com.phase.Phase3Project.entity.Citizens;
import com.phase.Phase3Project.repository.CitizensRepository;


@Service
public class CitizenService {
	
	@Autowired
	CitizensRepository cr;
	
	public List<Citizens> findAllCitizens(){
		return cr.findAll();
	}
	
	
	public Citizens findCitizen(Long id) {
		return cr.findById(id).get();
	}
	
	public void editCitizen(Long id,Citizens citizens) {
		Optional<Citizens> citizen = cr.findById(id);
		if(citizen.isPresent()) {
			Citizens c = citizen.get();
			c.setName(citizens.getName());
			c.setCenter(citizens.getCenter());
			c.setCity(citizens.getCity());
			c.setDoses(citizens.getDoses());
			c.setStatus(citizens.getStatus());
		
			cr.save(c);
		}
		
	}
	
	
	public void insertCitizen(Citizens citizen) {
		cr.save(citizen);
	}
	
	
	public void deleteById(@PathVariable Long id) {
		cr.deleteById(id);
	}
	
	
	public List<Citizens> finByCenterAndCity(String city,String center) {
		 return cr.findByCityAndCenter(city, center);
	}
	
}
