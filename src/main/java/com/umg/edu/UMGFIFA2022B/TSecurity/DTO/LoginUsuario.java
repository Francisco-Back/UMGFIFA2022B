package com.umg.edu.UMGFIFA2022B.TSecurity.DTO;

import javax.validation.constraints.NotBlank;


public class LoginUsuario {
    @NotBlank
    private String Email;
    @NotBlank
    private String Password;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
}