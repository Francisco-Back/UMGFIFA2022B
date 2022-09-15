package com.umg.edu.UMGFIFA2022B.services.ImServices;

import java.util.List;
import java.util.Optional;

import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.services.dto.LigasInDTO;


public interface ImLigasServices  {


	LigasEntity createLiga(Long UserID, LigasInDTO Ligasuser);

	List<LigasEntity> SetLigas();

	Optional<LigasEntity> findAllByLigas(Long UserID);

	LigasEntity ObtenerLiga(Long Id);

	void EliminarLiga(Long Id);

	LigasEntity LigaUser(Long Id);

	List<LigasInDTO> findAll();
	
	
}
