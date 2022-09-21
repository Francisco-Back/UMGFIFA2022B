package com.umg.edu.UMGFIFA2022B.TSecurity.DTO;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String Email;
    private Collection<? extends GrantedAuthority> authorities;


    
    
    public JwtDto(String token, String email, Collection<? extends GrantedAuthority> authorities) {
		this.token = token;
		this.Email = email;
		this.authorities = authorities;
	}

	public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }



    public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
