package com.umg.edu.UMGFIFA2022B.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Usuario;
import com.umg.edu.UMGFIFA2022B.TSecurity.Repository.UsuarioRepository;
import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.entity.UserLigaEntity;
import com.umg.edu.UMGFIFA2022B.mapper.UserLIgasInDTOoUserLigasEntity;
import com.umg.edu.UMGFIFA2022B.repository.LigasRepository;
import com.umg.edu.UMGFIFA2022B.repository.UserLIgasRepository;
import com.umg.edu.UMGFIFA2022B.services.ImServices.ImUserLigas;

import com.umg.edu.UMGFIFA2022B.services.dto.UserLigasDTO;

@Service
public class UserLigasService implements  ImUserLigas{
	
	@Autowired
	private   LigasRepository ligasRepository;
    
	@Autowired
    private  UserLIgasRepository UsLigasRepository;
    
	@Autowired
	private UsuarioRepository usuarioRepository;
    
	private   UserLIgasInDTOoUserLigasEntity USLmapper;

	
	
	@Override
	public UserLigaEntity UnionLiga(Long UserID, Long LigasID,UserLigasDTO dto) {
		
	    UserLigaEntity LigasE= USLmapper.map(dto);
		 Usuario e= usuarioRepository.findById(UserID)
				 .orElseThrow(); 
		 LigasE.setUsuario(e);;
		 LigasEntity l=ligasRepository.findById(LigasID)
				 .orElseThrow();
		 LigasE.setLigasEntity(l);
		 
		return this.UsLigasRepository.save(LigasE);
	}
	
	
	
	

}
