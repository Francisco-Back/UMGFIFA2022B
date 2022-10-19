package com.umg.edu.UMGFIFA2022B.services;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.umg.edu.UMGFIFA2022B.RabbitMQ.RabbitProductor;
import com.umg.edu.UMGFIFA2022B.entity.PartidoEntity;
import com.umg.edu.UMGFIFA2022B.entity.VaticinioAuxEntity;
import com.umg.edu.UMGFIFA2022B.entity.VaticinioEntity;
import com.umg.edu.UMGFIFA2022B.repository.VaticinioRepository;
import com.umg.edu.UMGFIFA2022B.services.ImServices.ImVaticinioServices;

@Service
public class VaticinioService implements ImVaticinioServices {
	   @Autowired
	private VaticinioRepository vaticinioRepository; 
	   @Autowired
	   private RabbitProductor rabbitProductor; 
	   
	  
	   
	   @Override
	   public void SenRabbit(VaticinioAuxEntity vaticinioAuxEntity) {
		   
		   this.rabbitProductor.send(vaticinioAuxEntity);
		   
	   }
	   
	   @Override
	   public List<VaticinioEntity> ListarVat(Long LigaID, Long VPartido){
		   
		   return this.vaticinioRepository.ListarVat(LigaID, VPartido);
		  
	   }
	   
	   
	   @Override
	   public Optional<VaticinioEntity> SearchVat(Long ID) {
		   
		   return this.vaticinioRepository.findById(ID);
	   }
	   
	   
	   @Override
	   public List<VaticinioEntity> SearchAll(Long UserID){
		   
		   return this.vaticinioRepository.VatAllU(UserID);
		   
	   }
	   
	   @Override
	   public List<VaticinioEntity> SearchPartido(Long UsParIDerID){
		   
		   return this.vaticinioRepository.PartidoAll(UsParIDerID);
		   
	   }
	   
	   @Transactional
	    @Override
		public void UpdateRanking(Long ID, int Ranking) {
			
			 this.vaticinioRepository.RankingVat(Ranking, ID);
		}

	   @Override
	   public void save(VaticinioEntity vaticinioEntity ){
		   System.out.println("Paso 3 servicio");
	        vaticinioRepository.save(vaticinioEntity);
	    }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
}
