package com.umg.edu.UMGFIFA2022B.TSecurity.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Rol;
import com.umg.edu.UMGFIFA2022B.TSecurity.enums.RolNombre;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}

