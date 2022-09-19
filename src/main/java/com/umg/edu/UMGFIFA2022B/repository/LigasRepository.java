package com.umg.edu.UMGFIFA2022B.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;


@Repository
public interface LigasRepository extends JpaRepository<LigasEntity, Long>{

	@Query(value = "SELECT * FROM ligas WHERE user_entity_id =:id", nativeQuery = true)
	public List<LigasEntity> findByUserEntity_id(Long id);
	
	  
}
