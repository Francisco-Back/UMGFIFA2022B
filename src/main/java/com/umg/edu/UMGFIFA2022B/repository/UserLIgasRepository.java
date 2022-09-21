package com.umg.edu.UMGFIFA2022B.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.umg.edu.UMGFIFA2022B.entity.UserLigaEntity;
import com.umg.edu.UMGFIFA2022B.entity.Enum.EstadoLigas;

@Repository
public interface UserLIgasRepository extends JpaRepository<UserLigaEntity, Long> {
	
	@Query(value = "SELECT * FROM user_ligas WHERE ligasid =:LigasID", nativeQuery = true)
	List<UserLigaEntity> searchLigasID(Long LigasID);
	@Query(value = "SELECT * FROM user_ligas WHERE userid =:UserID", nativeQuery = true)
	List<UserLigaEntity> searchUserID(Long UserID);
	@Query(value = "SELECT * FROM user_ligas WHERE estado =:estado", nativeQuery = true)
    public List<UserLigaEntity> findAllByEstado(EstadoLigas estado);
	@Modifying
	@Query(value = "UPDATE user_ligas SET estado=:estado WHERE id=:ID", nativeQuery = true)
	public void CEsatado(EstadoLigas estado, Long ID);
}

