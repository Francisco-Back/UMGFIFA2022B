package com.umg.edu.UMGFIFA2022B.entity;



import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Rol;

import lombok.Data;

@Data
@Entity
@Table(name="Usuarios")
public  class UserEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
@Column(name="Nombre")
    private String Nombre;
@NotNull
@Column(unique = true)
private String nombreUsuario;
@Column(name="correo")
    private String correo;
@Column(name="Avatar")
	private String Avatar;
@Column(name="Password")
	private String Password;
	//private String Token;
@Column(name="createDate")
	private LocalDateTime createDate;

@NotNull
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id"))

private Set<Rol> roles = new HashSet<>();


public Set<Rol> getRoles() {
    return roles;
}

public void setRoles(Set<Rol> roles) {
    this.roles = roles;
}

	}

	


