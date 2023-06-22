package com.example.Micro2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Micro2.entity.HobbyEntity;
import com.example.Micro2.repository.HobbyRepository;

@Service
public class HobbyService {

    @Autowired
    HobbyRepository hobbyRepository;
    
    public String findByPersonId(int personid){
        return hobbyRepository.findByPersonId(personid);
    }   
    public void addHobby(HobbyEntity he){
        hobbyRepository.save(he);
    }
}


