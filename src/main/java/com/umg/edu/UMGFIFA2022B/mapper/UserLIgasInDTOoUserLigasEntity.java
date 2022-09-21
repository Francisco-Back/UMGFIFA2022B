package com.umg.edu.UMGFIFA2022B.mapper;

import org.springframework.stereotype.Component;

import com.umg.edu.UMGFIFA2022B.entity.UserLigaEntity;

import com.umg.edu.UMGFIFA2022B.entity.Enum.EstadoLigas;
import com.umg.edu.UMGFIFA2022B.services.dto.UserLigasDTO;

@Component
public class UserLIgasInDTOoUserLigasEntity implements IMapper<UserLigasDTO, UserLigaEntity> {

	@Override
	public UserLigaEntity map(UserLigasDTO in) {
		UserLigaEntity ULE=new UserLigaEntity();
		ULE.setEstado(EstadoLigas.Pendiente);
		
		return ULE;
	}
	
	

}
