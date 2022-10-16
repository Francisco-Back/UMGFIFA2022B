package com.umg.edu.UMGFIFA2022B.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="partidos")
public class PartidoEntity{
	@Id
	   @Column(name="ID")
	    public Long ID;
	   @Column(name="Marcador1")
	    public int marcador1;
	   @Column(name="Marcador2")
	    public int marcador2;
	   @Column(name="AM")
	    public String am;
	   @Column(name="Bandera1")
	    public String bandera1;
	   @Column(name="Bandera2") 
	    public String bandera2;
	   @Column(name="Columna")
	    public String columna;
	   @Column(name="Fecha")
	    public String fecha;
	   @Column(name="Grupos")
	    public String grupos;
	   @Column(name="Horario")
	    public String horario;
	   @Column(name="Jornada")
	    public int jornada;
	   @Column(name="Pais1")
	    public String pais1;
	   @Column(name="Pais2") 
	    public String pais2;

	   
	   
	  
}

