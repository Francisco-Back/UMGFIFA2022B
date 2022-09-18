package com.umg.edu.UMGFIFA2022B.services;


import org.springframework.stereotype.Service;

import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.entity.UserEntity;
import com.umg.edu.UMGFIFA2022B.entity.UserLigaEntity;
import com.umg.edu.UMGFIFA2022B.mapper.UserLIgasInDTOoUserLigasEntity;
import com.umg.edu.UMGFIFA2022B.repository.LigasRepository;
import com.umg.edu.UMGFIFA2022B.repository.UserLIgasRepository;
import com.umg.edu.UMGFIFA2022B.repository.UserRepository;
import com.umg.edu.UMGFIFA2022B.services.ImServices.ImUserLigas;

import com.umg.edu.UMGFIFA2022B.services.dto.UserLigasDTO;

@Service
public class UserLigasService implements  ImUserLigas{
	
	private  final LigasRepository ligasRepository;
    
    private  final UserRepository userrepository;
    
    private final UserLIgasRepository UsLigasRepository;
    
	private final  UserLIgasInDTOoUserLigasEntity USLmapper;

	public UserLigasService(LigasRepository ligasRepository, UserRepository userrepository,
			UserLIgasRepository usLigasRepository, UserLIgasInDTOoUserLigasEntity uSLmapper) {
		this.ligasRepository = ligasRepository;
		this.userrepository = userrepository;
		this.UsLigasRepository = usLigasRepository;
		this.USLmapper = uSLmapper;
	}
	
	
	@Override
	public UserLigaEntity UnionLiga(Long UserID, Long LigasID,UserLigasDTO dto) {
		
	    UserLigaEntity LigasE= USLmapper.map(dto);
		/* UserEntity e= userrepository.findById(UserID)
				 .orElseThrow(); 
		 LigasE.setUserEntity(e);;
		 LigasEntity l=ligasRepository.findById(LigasID)
				 .orElseThrow();
		 LigasE.setLigasEntity(l);*/
		 
		return this.UsLigasRepository.save(LigasE);
	}
	
	
	
	

}
