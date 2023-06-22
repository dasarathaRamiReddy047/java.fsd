package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.PersonEntity;
import com.example.response.PersonResponse;
import com.example.service.PersonService;

@RestController
@RequestMapping(path = "/webapione")
public class PersonControlller {

    @Autowired
    PersonService personService;
    
    @RequestMapping("/person/{personId}")
    public PersonResponse getPerson(@PathVariable int personId){
        return personService.getPerson(personId);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/person")   
    public void addPerson(@RequestBody PersonEntity pe ) {
        personService.addPerson(pe);
    }
}

