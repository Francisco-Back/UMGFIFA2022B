package com.umg.edu.UMGFIFA2022B.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umg.edu.UMGFIFA2022B.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
<<<<<<< HEAD
	@Query(value = "SELECT * FROM usuarios WHERE correo =:correo", nativeQuery = true)
	public List<UserEntity> findByCorreo(String correo);
	
=======
>>>>>>> parent of b4888e7 (SearchEmailUser)
       
}

 