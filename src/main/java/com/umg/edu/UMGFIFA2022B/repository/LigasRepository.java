package com.umg.edu.UMGFIFA2022B.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;

import java.util.List;

import javax.transaction.Transactional;

public interface LigasRepository extends JpaRepository<LigasEntity, Long>{
	/*List<LigasEntity> findByLigaID(Long UserEntity_id);
	 
	 @Transactional
	  void deleteByLigaID(long UserEntity_id);*/
}
