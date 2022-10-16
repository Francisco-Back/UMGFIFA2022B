package com.umg.edu.UMGFIFA2022B.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umg.edu.UMGFIFA2022B.entity.VaticinioEntity;

@Repository
public interface VaticinioRepository   extends JpaRepository<VaticinioEntity, Long>{

	
	
	
}
