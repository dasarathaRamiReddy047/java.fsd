package com.phase.Phase3Project.repository;







import org.springframework.data.jpa.repository.JpaRepository;

import com.phase.Phase3Project.entity.Centers;

public interface CentersRepository extends JpaRepository<Centers, Long>{
	
	Centers findByCityAndCenter(String city, String center);

}
