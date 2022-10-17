package com.umg.edu.UMGFIFA2022B.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.umg.edu.UMGFIFA2022B.entity.PartidoEntity;
import com.umg.edu.UMGFIFA2022B.repository.PartidosRepository;
import com.umg.edu.UMGFIFA2022B.services.ImServices.ImPartidoService;

@Service
public class PartidosService implements ImPartidoService {

	@Autowired
	private PartidosRepository partidosRepository;
	
	
	   @Override
	   public void save(PartidoEntity partidoEntity){
	        partidosRepository.save(partidoEntity);
	    }
	   
	   @Override
	   public PartidoEntity Search(Long Columna) {
		   return this.partidosRepository.SearchIDC(Columna);
	   }
	   
	@Transactional
    @Override
	public void Resultados(int Mar1, int Mar2, Long col) {
		
		 this.partidosRepository.Marcador(Mar1, Mar2, col);
	}
	    
	    
	  @Override
	 public List<PartidoEntity> Partidos(){
		 return this.partidosRepository.findAll();
	 }
	 
	  public int[] ObtResul(Long Columna) {
		  PartidoEntity RTE=new PartidoEntity();
		  RTE=this.partidosRepository.SearchIDC(Columna);
		  int[] Resultado= new int[2];
		  int Mar1= RTE.getMarcador1();
		  int Mar2=RTE.getMarcador2();
		  Resultado[1]=Mar1;
		  Resultado[2]=Mar2;
		  return Resultado;
	  }

	  
	   	
	
}
