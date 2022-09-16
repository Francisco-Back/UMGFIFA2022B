package com.umg.edu.UMGFIFA2022B.entity;


import lombok.Data;

@Data
public class LoginEntity {
	private Integer Tiempo;
    private String User;
    private String Password;

	public LoginEntity(Integer tiempo, String user, String password) {
		Tiempo = tiempo;
		User = user;
		Password = password;
	}
	

	




	

}
