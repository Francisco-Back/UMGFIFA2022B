package com.umg.edu.UMGFIFA2022B.services.ImServices;

import java.util.List;
import java.util.Optional;

import com.umg.edu.UMGFIFA2022B.entity.UserEntity;
import com.umg.edu.UMGFIFA2022B.services.dto.UserlnDTO;

public interface ImUserService {

	UserEntity ObtenerUsuario(Long Id);

	List<UserEntity> SetUser();

	List<UserEntity> Correodd(String c) throws Exception;

	List<UserEntity> getByNombreUsuario(String nombreUsuario);

	boolean existsByNombreUsuario(String nombreUsuario);

	boolean existsByEmail(String email);

	List<UserEntity> findByCorreo(String Correo);

	UserEntity createUser(UserEntity user);



}
