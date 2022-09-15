package com.umg.edu.UMGFIFA2022B.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.entity.UserEntity;
import com.umg.edu.UMGFIFA2022B.mapper.LigasInDTOoLigasEntity;
import com.umg.edu.UMGFIFA2022B.repository.LigasRepository;
import com.umg.edu.UMGFIFA2022B.repository.UserRepository;
import com.umg.edu.UMGFIFA2022B.services.dto.LigasInDTO;






@Service
public class LigaServices {
	
    @Autowired
	private final LigasRepository ligasRepository;
    @Autowired 
    private final UserRepository userrepository;
    
	private final LigasInDTOoLigasEntity LigaMapper;
	



	public LigaServices(LigasRepository ligasRepository, UserRepository userrepository,
			LigasInDTOoLigasEntity ligaMapper) {
		this.ligasRepository = ligasRepository;
		this.userrepository = userrepository;
		LigaMapper = ligaMapper;
	}


	//Crear Liga
	public LigasEntity createLiga(Long UserID,LigasInDTO Ligasuser) {
		 LigasEntity LigasE= LigaMapper.map(Ligasuser);
		/* UserEntity e= userrepository.findById(UserID)
				 .orElseThrow(() -> new ResourceNotFoundException("Usuarios", "id", UserID)); */
		 UserEntity e= userrepository.findById(UserID)
				 .orElseThrow(); 
		 LigasE.setUserEntity(e);
		 
		return this.ligasRepository.save(LigasE);
	}
	
	
	//se obtiene todos la lista de los 
   public List<LigasEntity> SetLigas(){
	return this.ligasRepository.findAll();
	}	
   
	//obtener lista de ligas Usuario
public Optional<LigasEntity> findAllByLigas(Long UserID){
	
return this.ligasRepository.findById(UserID);	
}

//Retorna Una liga por ID
public LigasEntity ObtenerLiga(Long Id) {
	return this.ligasRepository.findById(Id).get();
}

//Eliminar Liga
public void EliminarLiga(Long Id) {
	this.ligasRepository.deleteById(Id);
}

public LigasEntity LigaUser(Long Id) {
	return this.ligasRepository.findByUserEntity_id(Id);
}



	

	
	
}
