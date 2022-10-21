package com.umg.edu.UMGFIFA2022B.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Usuario;
import com.umg.edu.UMGFIFA2022B.entity.UserLigaEntity;

@Repository
public interface UserLIgasRepository extends JpaRepository<UserLigaEntity, Long> {
	
	@Query(value = "SELECT * FROM user_ligas WHERE ligasid =:LigasID", nativeQuery = true)
	List<UserLigaEntity> searchLigasID(Long LigasID);
	@Query(value = "SELECT * FROM user_ligas WHERE ligasid =:LigasID order by puntaje desc", nativeQuery = true)
	List<UserLigaEntity> ordenmayor(Long LigasID);
	@Query(value = "SELECT * FROM user_ligas WHERE ligasid =:LigasID order by ranking desc", nativeQuery = true)
	List<UserLigaEntity> ordenmayorranling(Long LigasID);
	
	@Query(value = "SELECT userid FROM user_ligas WHERE ligasid =:LigasID", nativeQuery = true)
	List<Usuario> ObUseliga(Long LigasID);
	
	@Query(value = "SELECT * FROM user_ligas WHERE userid =:UserID", nativeQuery = true)
	List<UserLigaEntity> searchUserID(Long UserID);
	
	@Query(value = "SELECT * FROM user_ligas WHERE estado =:estado", nativeQuery = true)
    public List<UserLigaEntity> findAllByEstado(int estado);
	
	@Query(value = "select * from user_ligas where userid=:id1 and ligasid=:id2 ", nativeQuery = true)
    public UserLigaEntity Resultadoall( @Param("id1")  Long id1,@Param("id2")  Long id2);
	
	
	
	@Modifying
	@Query(value = "UPDATE user_ligas SET estado=:tado WHERE id=:ID", nativeQuery = true)
	public void CEsatado(@Param("tado") int tado, @Param("ID")Long ID);
	
	@Modifying
	@Query(value = "UPDATE user_ligas SET puntaje=:tado WHERE userid=:iduser and ligasid=:Idliga ", nativeQuery = true)
	public void  Punteo(@Param("tado") int tado, @Param("iduser")Long iduser,@Param("Idliga")Long Idliga);
	
	@Modifying
	@Query(value = "UPDATE user_ligas SET ranking=:tado WHERE id=:ID", nativeQuery = true)
	public void Ranking(@Param("tado") int tado, @Param("ID")Long ID);
	
	@Modifying
	@Query(value = "UPDATE user_ligas SET ranking=:tado,puntaje=:tado2 WHERE id=:ID", nativeQuery = true)
	public void RankingandPunteo(@Param("tado") int tado,@Param("tado2") int tado2, @Param("ID")Long ID);
	
}

