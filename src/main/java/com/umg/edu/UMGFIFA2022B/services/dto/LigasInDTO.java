package com.umg.edu.UMGFIFA2022B.services.dto;

import lombok.Data;

@Data
public class LigasInDTO {
	
	//User ID
	private Long UserEntity_id;
	private String NombreLiga;
	   private String Fecha_Inicio;
	   private String Fecha_Final;
	   private int Cant_Equipos;

}
