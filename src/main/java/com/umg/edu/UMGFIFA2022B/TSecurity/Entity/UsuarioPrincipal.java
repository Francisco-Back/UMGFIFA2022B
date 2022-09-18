package com.umg.edu.UMGFIFA2022B.TSecurity.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.umg.edu.UMGFIFA2022B.entity.UserEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {

	
	
	private String nombre;
    private String nombreUsuario;
    private String Correo;
    private String Avatar;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;




	public UsuarioPrincipal(String nombre, String nombreUsuario, String correo, String avatar, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.Correo = correo;
		this.Avatar = avatar;
		this.password = password;
		this.authorities = authorities;
	}

	public static UsuarioPrincipal build(UserEntity userEntity){
        List<GrantedAuthority> authorities =
        		userEntity.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
        				.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(userEntity.getNombre(), userEntity.getNombreUsuario(), userEntity.getCorreo(),userEntity.getAvatar(), userEntity.getPassword(), authorities);
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nombreUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {
	
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return Correo;
	}

	
	
}
