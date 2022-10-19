package com.umg.edu.UMGFIFA2022B.services.ImServices;

import java.util.List;
import java.util.Optional;

import com.umg.edu.UMGFIFA2022B.entity.VaticinioAuxEntity;
import com.umg.edu.UMGFIFA2022B.entity.VaticinioEntity;

public interface ImVaticinioServices {

	List<VaticinioEntity> ListarVat(Long LigaID, Long VPartido);

	Optional<VaticinioEntity> SearchVat(Long ID);

	List<VaticinioEntity> SearchAll(Long UserID);

	List<VaticinioEntity> SearchPartido(Long UsParIDerID);

	void UpdateRanking(Long ID, int Ranking);

	void SenRabbit(VaticinioAuxEntity vaticinioAuxEntity);

	void save(VaticinioEntity vaticinioEntity);

}
