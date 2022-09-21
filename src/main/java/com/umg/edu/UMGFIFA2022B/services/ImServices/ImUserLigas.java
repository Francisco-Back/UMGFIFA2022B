package com.umg.edu.UMGFIFA2022B.services.ImServices;

import com.umg.edu.UMGFIFA2022B.entity.UserLigaEntity;
import com.umg.edu.UMGFIFA2022B.services.dto.UserLigasDTO;

public interface ImUserLigas {

	UserLigaEntity UnionLiga(Long UserID, Long LigasID, UserLigasDTO dto);

}
