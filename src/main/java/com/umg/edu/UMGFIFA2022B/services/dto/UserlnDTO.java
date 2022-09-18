package com.umg.edu.UMGFIFA2022B.services.dto;




import java.util.Set;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Rol;

import lombok.Data;

@Data
public  class UserlnDTO {

	 private String Nombre;
	 private String NombreUser;
	    private String Correo;
		private String Avatar;
		private String Password;
	private Set<Rol> roles ;
	
}

