package com.umg.edu.UMGFIFA2022B.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.umg.edu.UMGFIFA2022B.entity.PartidoEntity;



@Repository
public interface PartidosRepository  extends JpaRepository<PartidoEntity, Long> {
	@Query(value = "SELECT * FROM partidos WHERE columna =:Col", nativeQuery = true)
	PartidoEntity SearchIDC(Long Col);
	
	
	@Modifying
	@Query(value = "UPDATE partidos SET marcador1=:tado1,marcador2=:tado2  WHERE id=:ID", nativeQuery = true)
	public void Marcador(@Param("tado1") int tado1,@Param("tado2") int tado2, @Param("ID")Long ID);

	
}
