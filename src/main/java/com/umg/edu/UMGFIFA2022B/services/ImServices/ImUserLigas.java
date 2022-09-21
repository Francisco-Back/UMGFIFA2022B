package com.umg.edu.UMGFIFA2022B.services.ImServices;

import java.util.List;

import com.umg.edu.UMGFIFA2022B.entity.UserLigaEntity;
import com.umg.edu.UMGFIFA2022B.entity.Enum.EstadoLigas;
import com.umg.edu.UMGFIFA2022B.services.dto.UserLigasDTO;

public interface ImUserLigas {

	UserLigaEntity UnionLiga(Long UserID, Long LigasID);

	List<UserLigaEntity> SearchIdLiga(Long IDLiga);

	List<UserLigaEntity> SearchIdUser(Long IdUser);

	List<UserLigaEntity> Estados(EstadoLigas estadoLigas);

	void updateEstados(Long id, EstadoLigas estadoLigas);



}
