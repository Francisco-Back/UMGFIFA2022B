package com.umg.edu.UMGFIFA2022B.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.umg.edu.UMGFIFA2022B.entity.UserEntity;
import com.umg.edu.UMGFIFA2022B.services.dto.UserlnDTO;


@Component
public class UserInDTOoUseEntity implements IMapper<UserlnDTO, UserEntity> {

	@Override
	public UserEntity map(UserlnDTO in){
		
	UserEntity UserE=new UserEntity();
	UserE.setNombre(in.getNombre());
	UserE.setNombreUsuario(in.getNombreUser());
	UserE.setCorreo(in.getCorreo());
	UserE.setAvatar(in.getAvatar());
	UserE.setPassword(in.getPassword());
	UserE.setCreateDate(LocalDateTime.now());
	UserE.setRoles(in.getRoles());	
		return UserE;
	}

	
}
