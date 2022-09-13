package com.umg.edu.UMGFIFA2022B.entity;



import java.time.LocalDateTime;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="Usuarios")
public  class UserEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String Nombre;
    private String Correo;
	private String Avatar;
	private String Password;
	//private String Token;
	private LocalDateTime createDate;

	}

	


