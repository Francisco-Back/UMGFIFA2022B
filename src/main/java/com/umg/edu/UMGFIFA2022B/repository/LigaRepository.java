package com.umg.edu.UMGFIFA2022B.repository;

import com.umg.edu.UMGFIFA2022B.entity.Liga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LigaRepository extends JpaRepository<Liga, Integer>{

    Optional<Liga> findByNombreLiga(String nombreLiga);
    boolean existsByNombreLiga(String nombreLiga);
}
