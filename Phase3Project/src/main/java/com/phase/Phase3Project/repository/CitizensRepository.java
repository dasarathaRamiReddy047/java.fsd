package com.phase.Phase3Project.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;


import com.phase.Phase3Project.entity.Citizens;

public interface CitizensRepository extends JpaRepository<Citizens, Long>{
    List<Citizens> findByCityAndCenter(String city, String center);
	
    List<Citizens> findByname(String name);
}
