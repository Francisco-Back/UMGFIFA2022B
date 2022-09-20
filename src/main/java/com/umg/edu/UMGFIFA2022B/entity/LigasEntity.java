package com.umg.edu.UMGFIFA2022B.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Usuario;

import lombok.Data;

@Data
@Entity
@Table(name="liga")
public class LigasEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
   @Column(name="NombreLiga")
   private String NombreLiga;
   @Column(name="Fecha_Inicio")
   private String Fecha_Inicio; 
   @Column(name="Fecha_Final")
   private String Fecha_Final;
   @Column(name="Cant_Equipos")
   private int Cant_Equipos;
   
   @NotNull
   @ManyToOne( cascade = CascadeType.ALL)
   @JoinColumn(foreignKey = @ForeignKey(name = "ligas_pkey"), name="usuario_ID", referencedColumnName = "id", columnDefinition = "int8")
   private Usuario usuario;
   
 
}
