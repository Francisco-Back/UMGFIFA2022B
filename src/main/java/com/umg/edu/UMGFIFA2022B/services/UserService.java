package com.umg.edu.UMGFIFA2022B.services;

import org.springframework.stereotype.Service;
import java.util.List;
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



    
	
}
