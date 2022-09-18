package com.umg.edu.UMGFIFA2022B.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import com.umg.edu.UMGFIFA2022B.entity.UserEntity;
import com.umg.edu.UMGFIFA2022B.mapper.UserInDTOoUseEntity;
import com.umg.edu.UMGFIFA2022B.repository.UserRepository;
import com.umg.edu.UMGFIFA2022B.services.ImServices.ImUserService;
import com.umg.edu.UMGFIFA2022B.services.dto.UserlnDTO;


@Service
public class UserService implements ImUserService {

	
	@Autowired
	private  UserRepository repository;
	private  UserInDTOoUseEntity mapper;
    private  PasswordEncoder passwordencoder;

	// Regresa el Objeto UserEntity 


	@Override
	public UserEntity createUser(UserEntity user) {	
		user.setPassword(passwordencoder.encode(user.getPassword()));
		// UserE.setRoles(RolNombre.ROLE_USER);
		return this.repository.save(user);	
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

	@Override
	public List<UserEntity> getByNombreUsuario(String nombreUsuario) {
		
		return this.getByNombreUsuario(nombreUsuario);
	}

	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<UserEntity> findByCorreo(String Correo){
		return this.repository.findByCorreo(Correo);
	}






    
	
}
