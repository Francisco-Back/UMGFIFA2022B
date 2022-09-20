package com.umg.edu.UMGFIFA2022B.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.umg.edu.UMGFIFA2022B.entity.Enum.EstadoLigas;

import lombok.Data;

@Data
@Entity
@Table(name="UserLigas")
public class UserLigaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	   @Column(name="UserID")
	   private Long UserID;
	   @Column(name="LigasID")
	   private Long LigasID;
	   @Column(name="Estado")
	   private EstadoLigas Estado;
	 
	 
}