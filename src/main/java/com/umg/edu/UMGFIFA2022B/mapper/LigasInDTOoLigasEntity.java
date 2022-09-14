package com.umg.edu.UMGFIFA2022B.mapper;



import org.springframework.stereotype.Component;

import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.services.dto.LigasInDTO;

@Component
public class LigasInDTOoLigasEntity implements IMapper<LigasInDTO, LigasEntity> {

	@Override
	public LigasEntity map(LigasInDTO in){
		
		LigasEntity LigasE=new LigasEntity();
		//user liga
		LigasE.setId(in.getId());
		LigasE.setNombreLiga(in.getNombreLiga());
		LigasE.setFecha_Inicio(in.getFecha_Inicio());
		LigasE.setFecha_Final(in.getFecha_Final());
		LigasE.setCant_Equipos(in.getCant_Equipos());
	
		return LigasE;
	}


	
	
}
