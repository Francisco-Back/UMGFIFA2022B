package com.umg.edu.UMGFIFA2022B.entity;

public class LoginEntity {
	private Integer Tiempo;
    private String User;
    private String Password;

	public LoginEntity(Integer tiempo, String user, String password) {
		super();
		Tiempo = tiempo;
		User = user;
		Password = password;
	}

	public Integer getTiempo() {
		return Tiempo;
	}

	public void setTiempo(Integer tiempo) {
		Tiempo = tiempo;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "LoginEntity [Tiempo=" + Tiempo + ", User=" + User + ", Password=" + Password + ", getTiempo()="
				+ getTiempo() + ", getUser()=" + getUser() + ", getPassword()=" + getPassword() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}





	

}
