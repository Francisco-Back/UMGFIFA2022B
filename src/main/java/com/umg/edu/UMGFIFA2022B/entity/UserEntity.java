package com.umg.edu.UMGFIFA2022B.entity;



import java.time.LocalDateTime;

import javax.persistence.*;

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
@Column(name="Correo")
    private String Correo;
@Column(name="Avatar")
	private String Avatar;
@Column(name="Password")
	private String Password;
	//private String Token;
@Column(name="createDate")
	private LocalDateTime createDate;
	
	  /* @OneToMany(mappedBy = "Usuarios", cascade = CascadeType.ALL,orphanRemoval = true)
		private  Set<LigasEntity> LigasUsuarios = new HashSet<>();*/
	 
	}

	


