package com.umg.edu.UMGFIFA2022B.services.ImServices;

import java.util.List;

import com.umg.edu.UMGFIFA2022B.entity.PartidoEntity;

public interface ImPartidoService {

	void save(PartidoEntity partidoEntity);

	List<PartidoEntity> Partidos();


	PartidoEntity Search(Long Columna);

	void Resultados(int Mar1, int Mar2, Long col, Long IdLiga);

}
