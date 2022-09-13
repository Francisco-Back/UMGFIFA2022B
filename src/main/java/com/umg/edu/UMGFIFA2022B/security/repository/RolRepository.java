package com.umg.edu.UMGFIFA2022B.security.repository;

import com.umg.edu.UMGFIFA2022B.security.entity.Rol;
import com.umg.edu.UMGFIFA2022B.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
