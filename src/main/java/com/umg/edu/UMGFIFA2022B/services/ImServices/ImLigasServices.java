package com.umg.edu.UMGFIFA2022B.services.ImServices;

import java.util.List;

import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.services.dto.LigasInDTO;


public interface ImLigasServices  {

	LigasEntity createLiga(Long UserID, LigasInDTO Ligasuser);

	List<LigasEntity> SetLigas();

	LigasEntity ObtenerLiga(Long Id);

	void EliminarLiga(Long Id);

	List<LigasEntity> LigaUser(Long Id);

	Long Verificador(Long Id);

	void Ranking(Long id, int Ranking);

	


	



}
