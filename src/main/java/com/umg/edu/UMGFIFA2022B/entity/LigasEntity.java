package com.umg.edu.UMGFIFA2022B.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
   @JsonProperty(access = Access.WRITE_ONLY)
   private UserEntity userEntity;
   
   @Column(name="NombreLiga")
   private String NombreLiga;
   @Column(name="Fecha_Inicio")
   private String Fecha_Inicio; 
   @Column(name="Fecha_Final")
   private String Fecha_Final;
   @Column(name="Cant_Equipos")
   private int Cant_Equipos;
   
   /*@OneToMany(mappedBy = "Ligas", cascade = CascadeType.ALL,orphanRemoval = true)
	private  Set<UserEntity> UsuariosLigas = new HashSet<>();
*/

}
