package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.example.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

}
