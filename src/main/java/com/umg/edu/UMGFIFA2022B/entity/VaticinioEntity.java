package com.umg.edu.UMGFIFA2022B.entity;

import lombok.Data;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Usuario;


@Data
@Entity
@Table(name="Vaticinio")
public class VaticinioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	   @Column(name="Partido")
	   private String Partido;
	   
	   @Column(name="Nombre")
	   private String Nombre;
	   
	   @Column(name="Vat1")
	   private int Vat1;
	   @Column(name="Vat2")
	   private int Vat2;
	   
	   @NotNull
	   @ManyToOne( cascade = CascadeType.ALL)
	   @JoinColumn( name="UserID", referencedColumnName = "id", columnDefinition = "int8")
	   private Usuario usuario;
	   
	   @NotNull
	   @ManyToOne( cascade = CascadeType.ALL)
	   @JoinColumn(name="LigasID", referencedColumnName = "id", columnDefinition = "int8")
	   private LigasEntity ligasEntity;
	   
	   @Column(name="FechaV")
	   private Date createDate;
	   
	 
	
	
	
	
}
