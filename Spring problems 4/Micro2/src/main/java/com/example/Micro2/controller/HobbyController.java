package com.example.Micro2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Micro2.entity.HobbyEntity;
import com.example.Micro2.service.HobbyService;

@RestController
@RequestMapping(path = "/webapitwo")
public class HobbyController {
    
    @Autowired
    HobbyService hobbyService;
    
    @RequestMapping("/hobby/{personid}")
    public String findByPersonId(@PathVariable int personid){
        return hobbyService.findByPersonId(personid);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/hobby")   
    public void addHobby(@RequestBody HobbyEntity he ) {
        hobbyService.addHobby(he);
    }

}

