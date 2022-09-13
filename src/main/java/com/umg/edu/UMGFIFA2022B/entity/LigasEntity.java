package com.umg.edu.UMGFIFA2022B.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="Ligas")
public class LigasEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
   
   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "UserEntity_id", nullable = false)
   @OnDelete(action = OnDeleteAction.CASCADE)
   @JsonIgnore
   private UserEntity userEntity;
   
   private String NombreLiga;
   private String Fecha_Inicio;
   private String Fecha_Final;
   private int Cant_Equipos;
   

}
