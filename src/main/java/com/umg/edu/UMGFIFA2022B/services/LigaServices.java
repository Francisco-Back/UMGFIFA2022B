package com .umg.edu.UMGFIFA2022B.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Usuario;
import com.umg.edu.UMGFIFA2022B.TSecurity.Repository.UsuarioRepository;
import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.mapper.LigasInDTOoLigasEntity;
import com.umg.edu.UMGFIFA2022B.repository.LigasRepository;
import com.umg.edu.UMGFIFA2022B.services.ImServices.ImLigasServices;
import com.umg.edu.UMGFIFA2022B.services.dto.LigasInDTO;






@Service
public class LigaServices  implements ImLigasServices{
	
   @Autowired
	private   LigasRepository ligasRepository;
   @Autowired
    private   UsuarioRepository userrepository;
   @Autowired
	private   LigasInDTOoLigasEntity LigaMapper;
	
 

	//Crear Liga
	@Override
	public LigasEntity createLiga(Long UserID,LigasInDTO Ligasuser) {
		 LigasEntity LigasE= LigaMapper.map(Ligasuser);
		 Usuario e= userrepository.findById(UserID)
				 .orElseThrow(); 
		 LigasE.setUsuario(e);
		 
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
public LigasEntity LigaUser(Long Id) {
	return this.ligasRepository.findByusuario_id(Id);
}


	
}
