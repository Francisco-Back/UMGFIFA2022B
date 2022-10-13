package com.umg.edu.UMGFIFA2022B.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import java.util.List;

@Repository
public interface LigasRepository extends JpaRepository<LigasEntity, Long>{

	@Query(value = "SELECT * FROM liga WHERE usuario_id =:id", nativeQuery = true)
	 List<LigasEntity> searhusuario_id(Long id);

	@Query(value = "SELECT * FROM liga WHERE id =:id", nativeQuery = true)
	LigasEntity Verificador(Long id);
	
	LigasEntity findByusuario_id(Long id);
	
	  
}
