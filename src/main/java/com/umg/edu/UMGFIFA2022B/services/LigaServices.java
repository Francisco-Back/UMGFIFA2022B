package com.umg.edu.UMGFIFA2022B.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.mapper.LigasInDTOoLigasEntity;
import com.umg.edu.UMGFIFA2022B.repository.LigasRepository;
import com.umg.edu.UMGFIFA2022B.services.dto.LigasInDTO;






@Service
public class LigaServices {

	private final LigasRepository ligasRepository;
	private final LigasInDTOoLigasEntity LigaMapper;
	
	public LigaServices(LigasRepository ligasRepository, LigasInDTOoLigasEntity ligaMapper) {
		this.ligasRepository = ligasRepository;
		this.LigaMapper = ligaMapper;
	}
	
	public LigasEntity createLiga(LigasInDTO Ligasuser) {
		 LigasEntity LigasE= LigaMapper.map(Ligasuser);
		return this.ligasRepository.save(LigasE);
	}
	
   public List<LigasEntity> SetLigas(){
	return this.ligasRepository.findAll();
	}	
	

	

	
	
}
