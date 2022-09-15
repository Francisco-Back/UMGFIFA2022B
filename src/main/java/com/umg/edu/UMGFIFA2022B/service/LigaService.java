package com.umg.edu.UMGFIFA2022B.service;

import com.umg.edu.UMGFIFA2022B.entity.Liga;
import com.umg.edu.UMGFIFA2022B.repository.LigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LigaService {

    @Autowired
    LigaRepository ligaRepository;

    public List<Liga> list(){
        return ligaRepository.findAll();
    }

    public Optional<Liga> getOne(int id){
        return ligaRepository.findById(id);
    }

    public Optional<Liga> getByNombreLiga(String nombreLiga){
        return ligaRepository.findByNombreLiga(nombreLiga);
    }

    public void save(Liga liga){
        ligaRepository.save(liga);
    }

    public boolean existById(int id){
        return ligaRepository.existsById(id);
    }

    public boolean existByNombreLiga(String nombreLiga){
        return ligaRepository.existsByNombreLiga(nombreLiga);
    }
}
