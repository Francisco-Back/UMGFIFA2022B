package com.umg.edu.UMGFIFA2022B.services.ImServices;

import java.util.List;

import com.umg.edu.UMGFIFA2022B.entity.UserEntity;
import com.umg.edu.UMGFIFA2022B.services.dto.UserlnDTO;

public interface ImUserService {

	UserEntity createUser(UserlnDTO user);

	UserEntity ObtenerUsuario(Long Id);

	List<UserEntity> SetUser();



}
