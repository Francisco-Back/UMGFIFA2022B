package com .umg.edu.UMGFIFA2022B.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.entity.UserEntity;
import com.umg.edu.UMGFIFA2022B.mapper.LigasInDTOoLigasEntity;
import com.umg.edu.UMGFIFA2022B.repository.LigasRepository;
import com.umg.edu.UMGFIFA2022B.repository.UserRepository;
import com.umg.edu.UMGFIFA2022B.services.ImServices.ImLigasServices;
import com.umg.edu.UMGFIFA2022B.services.dto.LigasInDTO;






@Service
public class LigaServices  implements ImLigasServices{
	
   
	private  final LigasRepository ligasRepository;
    
    private  final UserRepository userrepository;
    
	private final  LigasInDTOoLigasEntity LigaMapper;
	



	


	public LigaServices(LigasRepository ligasRepository, UserRepository userrepository,
			LigasInDTOoLigasEntity ligaMapper) {
		this.ligasRepository = ligasRepository;
		this.userrepository = userrepository;
		this.LigaMapper = ligaMapper;
	}


	//Crear Liga
	@Override
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
	@Override
   public List<LigasEntity> SetLigas(){
	return this.ligasRepository.findAll();
	}	
   
	//obtener lista de ligas Usuario
	@Override
public Optional<LigasEntity> findAllByLigas(Long UserID){
	
return this.ligasRepository.findById(UserID);	
}

//Retorna Una liga por ID
	@Override
public LigasEntity ObtenerLiga(Long Id) {
	return this.ligasRepository.findById(Id).get();
}

//Eliminar Liga
	@Override
public void EliminarLiga(Long Id) {
	this.ligasRepository.deleteById(Id);
}
@Override
public List<LigasEntity> LigaUser(Long Id) {
		
	return this.ligasRepository.findByUserEntity_id(Id);
}


@Override
public List<LigasInDTO> findAll() {
	// TODO Auto-generated method stub
	return null;
}



	

	
	
}
