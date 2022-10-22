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
		return this.UsLigasRepository.ordenmayorranling(LigaID);

	}

	@Override
	public void UpdateRanking(Long Idligas) {
		int Primero = 0;
		Long CPrimero = (long) 0;
		int Segundo = 0, menor = 0;
		Long CSegundo = (long) 0;
		int Tercero = 0, menorq = 0;
		Long CTercero = (long) 0;
		try {

			List<UserLigaEntity> gt = this.UsLigasRepository.ordenmayor(Idligas);
			System.out.println(gt);

			for (int i = 0; i < gt.size(); i++) {

				//System.out.println(gt.get(i));
				// primer dato

				if (i == 0) {
					Primero = gt.get(i).getPuntaje();
					CPrimero = gt.get(i).getId();

				}
				// segundo dato
				if (i == 1) {

					if (Primero == gt.get(i).getPuntaje()) {
						Segundo = gt.get(i).getPuntaje();
						CSegundo = gt.get(i).getId();
						this.Ranking(CPrimero, 50);
						this.Ranking(gt.get(i).getId(), 50);
					} else {
						Segundo = gt.get(i).getPuntaje();
						this.Ranking(gt.get(i).getId(), 35);
						this.Ranking(CPrimero, 50);
					}

				}
				// tercer dato
				if (i == 2) {
					if (gt.get(i).getPuntaje() == 0) {

					} else {

						if (Segundo == gt.get(i).getPuntaje()) {
							Tercero = gt.get(i).getPuntaje();
							CTercero = gt.get(i).getId();
							this.Ranking(CSegundo, 25);
							this.Ranking(gt.get(i).getId(), 25);
						} else {
							Tercero = gt.get(i).getPuntaje();
							this.Ranking(CSegundo, 35);
							this.Ranking(gt.get(i).getId(), 15);
						}
					}

					if (i == 3) {
						if (gt.get(i).getPuntaje() == 0) {

						} else {
					
						if (Tercero == gt.get(i).getPuntaje()) {
							this.Ranking(CTercero, 8);
							this.Ranking(gt.get(i).getId(), 8);
						} else {
							this.Ranking(CTercero, 15);
							this.Ranking(gt.get(i).getId(), 0);

						}
					}

				}
			}}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
