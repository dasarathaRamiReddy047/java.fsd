package com.phase.Phase3Project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.phase.Phase3Project.entity.Centers;
import com.phase.Phase3Project.entity.Citizens;
import com.phase.Phase3Project.service.CenterService;
import com.phase.Phase3Project.service.CitizenService;



@RestController
public class ProjectController {
  
	
	
	@Autowired
	CenterService cs;

	
	@Autowired
	CitizenService cis;
	
	
	@GetMapping("/vaccinationcenters")
	public List<Centers> getAllCenters(){
		return cs.findAllCenters();
	}
	
	
	@GetMapping("/vaccinationcenters/{id}")
	public Map<String, Object> getByIdCenter(@PathVariable Long id) {
	    Centers center = cs.findByCenter(id);
	    String ce = center.getCenter();
	    String city = center.getCity();
	    List<Citizens> citizen = cis.finByCenterAndCity(city, ce);

	    Map<String, Object> response = new HashMap<>();
	    response.put("center", center);
	    response.put("citizen", citizen);

	    return response;
	}



	
	@PutMapping("/vaccinationcenters/{id}")
	public void editCenter(@PathVariable Long id,@RequestBody Centers center) {
		cs.editCenter(id,center);
	}
	
	
	@PostMapping("vaccinationcenters")
	public void insertCenter(@RequestBody Centers center) {
		cs.insertCenter(center);
		
	}
	
	
	@DeleteMapping("/vaccinationcenters/{id}")
	public void delete(@PathVariable Long id) {
		cs.deleteCenter(id);
	}
	
	
	@GetMapping("/citizen")
	public List<Citizens> findAllCitizens() {
		return cis.findAllCitizens();
	}
	
	@GetMapping("/citizen/{id}")
	public Citizens findByCitizen(@PathVariable Long id) {
		return cis.findCitizen(id);
	}
	
	
	@PutMapping("citizen/{id}")
	public void editByCitizen(@PathVariable Long id,@RequestBody Citizens citizen) {
		cis.editCitizen(id,citizen);
	}
	
	@PostMapping("citizen")
	public void insertCitizen(@RequestBody Citizens citizen) {
		cis.insertCitizen(citizen);
	}
	
	@DeleteMapping("citizen/{id}")
	public void deleteCitizen(@PathVariable Long id) {
		cis.deleteById(id);
	}
	
	
	
	

}
	
   


