package com.umg.edu.UMGFIFA2022B.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Usuario;
import com.umg.edu.UMGFIFA2022B.TSecurity.Repository.UsuarioRepository;
import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.entity.UserLigaEntity;
import com.umg.edu.UMGFIFA2022B.entity.Enum.EstadoLigas;
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
    


	
	
    @Override
	public UserLigaEntity UnionLiga(Long UserID, Long LigasID) {
		
		UserLigaEntity LigasE=new UserLigaEntity();
	    
		 Usuario e= usuarioRepository.findById(UserID)
				 .orElseThrow(); 
		 LigasE.setUsuario(e);;
		 LigasEntity l=ligasRepository.findById(LigasID)
				 .orElseThrow();
		 LigasE.setLigasEntity(l);
		 LigasE.setEstado(EstadoLigas.Pendiente);
		return this.UsLigasRepository.save(LigasE);
	}
    
    
    @Override
	public List<UserLigaEntity> SearchIdLiga(Long LigasID){
		
		return this.UsLigasRepository.searchLigasID(LigasID);
		
	}
	
    @Override
public List<UserLigaEntity> SearchIdUser(Long UserID){
		
		return this.UsLigasRepository.searchUserID(UserID);
		
	}
    
    
    @Override
    public List<UserLigaEntity> Estados(int estadoLigas){
    	return this.UsLigasRepository.findAllByEstado(estadoLigas);
    }
	
    @Transactional
    @Override
	public void updateEstados(Long id, int estadoLigas) {
		
		 this.UsLigasRepository.CEsatado(estadoLigas, id);
	}

}
