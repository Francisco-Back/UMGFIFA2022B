package com.umg.edu.UMGFIFA2022B.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.umg.edu.UMGFIFA2022B.entity.VaticinioEntity;

@Repository
public interface VaticinioRepository   extends JpaRepository<VaticinioEntity, Long>{

	@Query(value = "select * from vaticinio WHERE ligasid=:LigaID and partidoid=:VPartido", nativeQuery = true)
	 List<VaticinioEntity> ListarVat(Long LigaID, Long VPartido);
	
	@Modifying
	@Query(value = "UPDATE vaticinio SET punteo=:tado WHERE id=:ID", nativeQuery = true)
	public void RankingVat(@Param("tado") int tado, @Param("ID")Long ID);
	
	@Query(value = "select * from vaticinio WHERE userid=:UserID", nativeQuery = true)
	 List<VaticinioEntity> VatAllU(Long UserID);
	
	@Query(value = "select * from vaticinio WHERE partidoid=:ParID", nativeQuery = true)
	 List<VaticinioEntity> PartidoAll(Long ParID);
	
}
