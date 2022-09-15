package com.umg.edu.UMGFIFA2022B.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;


@Repository
public interface LigasRepository extends JpaRepository<LigasEntity, Long>{

	LigasEntity findByUserEntity_id(Long id);
	
	  
}
