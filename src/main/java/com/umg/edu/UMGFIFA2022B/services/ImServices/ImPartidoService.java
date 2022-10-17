package com.umg.edu.UMGFIFA2022B.services.ImServices;

import java.util.List;

import com.umg.edu.UMGFIFA2022B.entity.PartidoEntity;

public interface ImPartidoService {

	void save(PartidoEntity partidoEntity);

	List<PartidoEntity> Partidos();

	void Resultados(int Mar1, int Mar2, Long Columna);

	PartidoEntity Search(Long Columna);

}
