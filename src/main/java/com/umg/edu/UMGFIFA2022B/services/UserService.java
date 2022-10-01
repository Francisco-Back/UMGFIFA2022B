package com.umg.edu.UMGFIFA2022B.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Usuario;
import com.umg.edu.UMGFIFA2022B.TSecurity.Repository.UsuarioRepository;
import com.umg.edu.UMGFIFA2022B.entity.UserEntity;
import com.umg.edu.UMGFIFA2022B.repository.UserLIgasRepository;
import com.umg.edu.UMGFIFA2022B.services.ImServices.ImUserService;
import com.umg.edu.UMGFIFA2022B.entity.UserLigaEntity;


@Service
public class UserService implements ImUserService {

	
	@Autowired
	private  UsuarioRepository repository;
	@Autowired
	private UserLIgasRepository lIgasRepository; 

	
	@Override
    public List<Usuario> SetUser(){
		
	return (List<Usuario>) this.repository.findAll();
	}
	
    //Buscar por Id Usuario
	@Override
    public Usuario ObtenerUsuario(Long Id) {
    	return this.repository.findById(Id).get();
    }

	@Override
	public List<Usuario> Correo(String c) throws Exception{
		try {
			List<Usuario> e=repository.Corro(c);
			return e;
		}catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
		
	}
	
	
	@Override
	public UserEntity UserID(String C) { 
		
		UserEntity r=new UserEntity();
		 Usuario e= repository.UserID(C);
		 r.setUserID(e.getId());;
		 r.setUserName(e.getNombre());
		 r.setAvatar(e.getAvatar());
		
		return r;
	}
	
	
	/*@Override
	public List<Usuario> OTUseliga(Long ID){
		return this.lIgasRepository.ObUseliga(ID);
	}
	*/
	
	@Override
	public List<Usuario> OTUseliga(Long ID){
    List<Usuario> rt= new LinkedList<>();
    

List<UserLigaEntity> Rist = lIgasRepository.searchLigasID(ID);
		for (int i = 0; i < Rist.size(); i++) {
			rt.add(	Rist.get(i).getUsuario());
		}
		return rt;
	}

	

    
	
}
