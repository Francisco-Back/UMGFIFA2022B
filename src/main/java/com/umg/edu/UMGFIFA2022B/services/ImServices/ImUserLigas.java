package com.umg.edu.UMGFIFA2022B.services.ImServices;

import java.util.List;

import com.umg.edu.UMGFIFA2022B.entity.UserLigaEntity;

public interface ImUserLigas {

	UserLigaEntity UnionLiga(Long UserID, Long LigasID);

	List<UserLigaEntity> SearchIdLiga(Long IDLiga);

	List<UserLigaEntity> SearchIdUser(Long IdUser);


	List<UserLigaEntity> Estados(int estadoLigas);

	void updateEstados(Long id, int estadoLigas);



}
