package com .umg.edu.UMGFIFA2022B.services;

import java.util.List;

import javax.transaction.Transactional;

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
public  List<LigasEntity> LigaUser(Long Id) {
	return this.ligasRepository.searhusuario_id(Id);
}
	@Override
public  Long Verificador(Long Id) {
		System.out.println("Metodo Verificador");
		System.out.println(this.ligasRepository.Verificador(Id).getUsuario().getId());
	return this.ligasRepository.Verificador(Id).getUsuario().getId();
}
	
    @Transactional
    @Override
	public void Ranking(Long id, int Ranking) {
		
		 this.ligasRepository.Ranking(Ranking, id);
	}
	


	
}
