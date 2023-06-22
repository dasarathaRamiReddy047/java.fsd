package com.phase.Phase3Project.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.phase.Phase3Project.entity.Centers;

import com.phase.Phase3Project.repository.CentersRepository;

@Service
public class CenterService {
	
	
	@Autowired
	CentersRepository cr;
	

	
	
	public List<Centers> findAllCenters(){
		return cr.findAll();
	}
	public Centers findByCenter(Long id) {
	
		return cr.findById(id).get();
	}

	
	public void editCenter(Long id, Centers ce) {
		Optional<Centers> centerOptional = cr.findById(id);
		if(centerOptional.isPresent()) {
			Centers c = centerOptional.get();
			c.setCenter(ce.getCenter());
			c.setCity(ce.getCity());
			cr.save(c);
		}
	}
		
		
		public void insertCenter(Centers center) {
			cr.save(center);
			
		}
		
		public void deleteCenter(Long id) {
			cr.deleteById(id);
		}
		
		
		public Centers findByCityAndCenter(String city, String center) {
			return cr.findByCityAndCenter(city, center);
		}
		
		
	}
	
	

