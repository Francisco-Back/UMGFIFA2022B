package com.umg.edu.UMGFIFA2022B.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import lombok.Data;

@Data
public class VaticinioAuxEntity implements Serializable{
	   private String Partido;
	   private String Nombre;
	   private int Vat1;
	   private int Vat2;
	   private int punteo;
	   private Long IDUser;
	   private Long IDLiga;
	   private Long IDPartido;
	   private Date createDate;
	   
	 

}
