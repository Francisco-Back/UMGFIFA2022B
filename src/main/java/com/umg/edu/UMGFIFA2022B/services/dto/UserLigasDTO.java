package com.umg.edu.UMGFIFA2022B.services.dto;

import com.umg.edu.UMGFIFA2022B.entity.Enum.EstadoLigas;

import lombok.Data;

@Data
public class UserLigasDTO {

	private Long UserID;
	private Long LigasID;
	private EstadoLigas estadoLigas;
	
}
