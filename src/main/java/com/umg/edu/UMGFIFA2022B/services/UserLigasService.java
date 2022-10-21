package com.umg.edu.UMGFIFA2022B.services;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Usuario;
import com.umg.edu.UMGFIFA2022B.TSecurity.Repository.UsuarioRepository;
import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.entity.UserLigaEntity;
import com.umg.edu.UMGFIFA2022B.entity.Enum.EstadoLigas;
import com.umg.edu.UMGFIFA2022B.repository.LigasRepository;
import com.umg.edu.UMGFIFA2022B.repository.UserLIgasRepository;
import com.umg.edu.UMGFIFA2022B.services.ImServices.ImUserLigas;

@Service
public class UserLigasService implements ImUserLigas {

	@Autowired
	private LigasRepository ligasRepository;

	@Autowired
	private UserLIgasRepository UsLigasRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserLigaEntity UnionLiga(Long UserID, Long LigasID) {

		UserLigaEntity LigasE = new UserLigaEntity();

		Usuario e = usuarioRepository.findById(UserID).orElseThrow();
		LigasE.setUsuario(e);
		LigasEntity l = ligasRepository.findById(LigasID).orElseThrow();
		LigasE.setLigasEntity(l);
		LigasE.setEstado(EstadoLigas.Pendiente);
		return this.UsLigasRepository.save(LigasE);
	}

	@Override
	public List<UserLigaEntity> SearchIdLiga(Long LigasID) {

		return this.UsLigasRepository.searchLigasID(LigasID);

	}

	@Override
	public List<UserLigaEntity> SearchIdUser(Long UserID) {

		return this.UsLigasRepository.searchUserID(UserID);

	}

	@Override
	public List<UserLigaEntity> Estados(int estadoLigas) {
		return this.UsLigasRepository.findAllByEstado(estadoLigas);
	}

	@Transactional
	@Override
	public void updateEstados(Long id, int estadoLigas) {

		this.UsLigasRepository.CEsatado(estadoLigas, id);
	}

	@Transactional
	@Override
	public void Ranking(Long id, int Ranking) {

		this.UsLigasRepository.Ranking(Ranking, id);
	}

	@Transactional
	@Override
	public void Punteo(Long Iduser, Long Idliga, int Punteo) {

		this.UsLigasRepository.Punteo(Punteo, Iduser, Idliga);
	}

	@Override
	public UserLigaEntity PunteoAll(Long Iduser, Long Idliga) {
		return this.UsLigasRepository.Resultadoall(Iduser, Idliga);
	}

	@Transactional
	@Override
	public void RankingandPunteo(Long id, int Punteo, int Ranking) {

		this.UsLigasRepository.RankingandPunteo(Punteo, Punteo, id);

	}

	@Override
	public List<UserLigaEntity> Ordenamiento(Long LigaID) {
		List<UserLigaEntity> rt = this.UsLigasRepository.searchLigasID(LigaID);
		int vr = rt.get(1).getRanking();
		if (vr == 0) {

			return this.UsLigasRepository.searchLigasID(LigaID);

		} else {

			Collections.sort(rt, (o1, o2) -> o1.getRanking());

			return rt;

		}

	}

	@Override
	public void UpdateRanking(Long Idligas) {
		int Primero=0, CPrimero=0 ;
		int Segundo=0, CSegundo=0, menor=0;
		int Tercero=0, CTercero=0, menorq=0;
		try {
			
	
		List<UserLigaEntity> gt = this.UsLigasRepository.searchLigasID(Idligas);
		ArrayList<Integer> a= new ArrayList<Integer>();
		//System.out.println(gt);
		for (int i = 0; i < gt.size(); i++) {
			a.add(gt.get(i).getPuntaje());	
		}
		
		Collections.sort(gt, (o1, o2) -> o1.getPuntaje());

		  for (UserLigaEntity datos: gt) {
		        System.out.println(datos);
		        
		    }  
		
	
		} catch (Exception e) {
			 System.out.println(e);
	    }  
		
	}
		

}
