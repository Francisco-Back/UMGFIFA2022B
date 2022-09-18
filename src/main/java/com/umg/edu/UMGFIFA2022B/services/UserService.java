package com.umg.edu.UMGFIFA2022B.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.umg.edu.UMGFIFA2022B.entity.UserEntity;
import com.umg.edu.UMGFIFA2022B.mapper.UserInDTOoUseEntity;
import com.umg.edu.UMGFIFA2022B.repository.UserRepository;
import com.umg.edu.UMGFIFA2022B.services.ImServices.ImUserService;
import com.umg.edu.UMGFIFA2022B.services.dto.UserlnDTO;


@Service
public class UserService implements ImUserService {

	private final UserRepository repository;
	private final UserInDTOoUseEntity mapper;

public UserService(UserRepository repository, UserInDTOoUseEntity mapper) {

		this.repository = repository;
		this.mapper = mapper;
	}

	// Regresa el Objeto UserEntity 
	@Override
	public UserEntity createUser(UserlnDTO user) {
		 UserEntity UserE= mapper.map(user);
		return this.repository.save(UserE);	
	}
	
	@Override
    public List<UserEntity> SetUser(){
	return (List<UserEntity>) this.repository.findAll();
	}
	
    //Buscar por Id Usuario
	@Override
    public UserEntity ObtenerUsuario(Long Id) {
    	return this.repository.findById(Id).get();
    }

	@Override
	public List<UserEntity> Correodd(String c) throws Exception{
		try {
			List<UserEntity> e=repository.findByCorreo(c);
			return e;
		}catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
		
	}

	@Override
	    public boolean existsByNombreUsuario(String nombreUsuario){
	        return repository.existsBynombreUsuario(nombreUsuario);
	    }
<<<<<<< Updated upstream

	    public boolean existsByCorreo(String Correo){
	        return repository.existsByCorreo(Correo);
=======
	@Override
	    public boolean existsByEmail(String email){
	        boolean Verifi=repository.existsByCorreo(email);
	        	if(Verifi==true) {
	        		return Verifi;
	        	}else {
	        		Verifi=false;
	        		return Verifi;
	        	}
	        		
	        		
>>>>>>> Stashed changes
	    }
	@Override
	    public void save(UserEntity usuario){
	    	repository.save(usuario);
	    }

	@Override
	public List<UserEntity> getByNombreUsuario(String nombreUsuario) {
		
		return this.getByNombreUsuario(nombreUsuario);
	}


    
	
}
