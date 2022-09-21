package com.umg.edu.UMGFIFA2022B.entity;



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
import com.umg.edu.UMGFIFA2022B.entity.Enum.EstadoLigas;

import lombok.Data;

@Data
@Entity
@Table(name="UserLigas")
public class UserLigaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	 /*@Column(name="UserID")
	 private Long UserID;
	 @Column(name="LigasID")
	   private Long LigasID;*/
	   @Column(name="Estado")
	   private EstadoLigas Estado;
	   
	   @NotNull
	   @ManyToOne( cascade = CascadeType.ALL)
	   @JoinColumn( name="UserID", referencedColumnName = "id", columnDefinition = "int8")
	   private Usuario usuario;
	   
	   @NotNull
	   @ManyToOne( cascade = CascadeType.ALL)
	   @JoinColumn(name="LigasID", referencedColumnName = "id", columnDefinition = "int8")
	   private LigasEntity ligasEntity;
	 
}
