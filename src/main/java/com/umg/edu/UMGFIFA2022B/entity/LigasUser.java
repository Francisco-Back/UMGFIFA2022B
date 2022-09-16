package com.umg.edu.UMGFIFA2022B.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.umg.edu.UMGFIFA2022B.entity.enumerado.LigaUserEn;

import lombok.Data;

@Data
@Entity
@Table(name="LigasUser")
public class LigasUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//Un usuario tiene varias ligas y que una liga tiene varios usuarios
	
	 /*  @ManyToMany(fetch = FetchType.LAZY, optional = false)
	   @JoinColumn(name = "LigasEntity_id", nullable = false)
	   @JsonProperty(access = Access.WRITE_ONLY)
	   private UserEntity userEntity;
	   
	   @ManyToMany(fetch = FetchType.LAZY, optional = false)
	   @JoinColumn(name = "UserEntity_id", nullable = false)
	   @JsonProperty(access = Access.WRITE_ONLY)
	   private LigasEntity ligasEntity;
	   
	   @Column(name="Estado")
	   private LigaUserEn Estado;
	   */
	   
}
