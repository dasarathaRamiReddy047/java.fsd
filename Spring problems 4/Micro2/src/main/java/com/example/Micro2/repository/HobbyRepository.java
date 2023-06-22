package com.example.Micro2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Micro2.entity.HobbyEntity;

@Repository
public interface HobbyRepository extends JpaRepository<HobbyEntity, Integer> {
    
       @Query("SELECT h.name FROM HobbyEntity h WHERE h.personId=:personId")
        public String findByPersonId(Integer personId);

}

