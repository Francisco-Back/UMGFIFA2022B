package com.umg.edu.UMGFIFA2022B.services.ImServices;

import java.util.List;

import com.umg.edu.UMGFIFA2022B.entity.PartidoEntity;

public interface ImPartidoService {

	void save(PartidoEntity partidoEntity);

	PartidoEntity Search(String Columna);

	void Resultados(int Mar1, int Mar2, String Columna);

	List<PartidoEntity> Partidos();

}
