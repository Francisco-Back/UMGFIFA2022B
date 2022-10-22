package com.umg.edu.UMGFIFA2022B.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.umg.edu.UMGFIFA2022B.entity.PartidoEntity;
import com.umg.edu.UMGFIFA2022B.entity.UserLigaEntity;
import com.umg.edu.UMGFIFA2022B.entity.VaticinioEntity;
import com.umg.edu.UMGFIFA2022B.repository.PartidosRepository;
import com.umg.edu.UMGFIFA2022B.services.ImServices.ImPartidoService;

@Service
public class PartidosService implements ImPartidoService {

	@Autowired
	private PartidosRepository partidosRepository;
	@Autowired
	private VaticinioService vaticinioService;
	@Autowired
	private UserLigasService userLigasService;
	
	
	
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
	public void Resultados(int Mar1, int Mar2, Long col, Long IdUseliga) {
		
		 this.partidosRepository.Marcador(Mar1, Mar2, col);
		 
		 //Llama a los usuarios de los partidos y liga
		 List<VaticinioEntity> det=this.vaticinioService.ListVatPart(col, IdUseliga);
		// System.out.println(det);
		 ResultadoCal(Mar1, Mar2, det,IdUseliga);
		  this.userLigasService.UpdateRanking(IdUseliga);
		 
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
        
	  //Metodo para la actulizacion de los resultados de los partidos
	  public boolean ResultadoCal(int Res1, int Res2, List<VaticinioEntity> lista,Long IdLIga) {
		 // System.out.println("paso 1");
		  //System.out.println(lista);
          try {
		
		  for (int i=0; i<lista.size(); i++) { 
			  int Punteo=0;
			//  System.out.println("Paso " +i);
			//  System.out.println(lista.size());
			//  System.out.println("Id Liga"+lista.get(i).getLigasEntity().getId());
			//  System.out.println("Id user"+lista.get(i).getUsuario().getId());
		       UserLigaEntity dert=this.userLigasService.PunteoAll(lista.get(i).getUsuario().getId(),lista.get(i).getLigasEntity().getId());
		    //  System.out.println(dert);
		     //  System.out.println(lista.get(i));
		       int aux=dert.getPuntaje();
			
		         if(Res1==lista.get(i).getVat1() && Res2==lista.get(i).getVat2()) {
		             if(Res1==Res2) {
		        		 Punteo=1; 
		        	//  System.out.println("punto empate "+ Punteo +"  "+ lista.get(i).getVat1() + lista.get(i).getVat2());
		        		 // System.out.println(dert);
			         }else {
			        	 Punteo=3;
			        	//  System.out.println("punto acerto "+ Punteo+"  " + lista.get(i).getVat1() + lista.get(i).getVat2());	
			        	 // System.out.println(dert);
			         }
		
			         } if(Res1!=lista.get(i).getVat1() || Res2!=lista.get(i).getVat2()) {
					        	 if(Res1==lista.get(i).getVat1()) {
					        		 Punteo=1; 
					        			
						        	// System.out.println("punto acerto 1= "+ Punteo + lista.get(i).getVat1() + lista.get(i).getVat2());
						        	 //System.out.println(dert);
					        	 }if(Res2== lista.get(i).getVat2()) {
					        		 Punteo=1; 
					        			
						        	// System.out.println("punto 1 de 2= "+ Punteo + lista.get(i).getVat1() + lista.get(i).getVat2());
						        	 //System.out.println(dert);
					        	 }
					        	 
					        
					        	// this.vaticinioService.UpdateRanking(lista.get(i).getId(),Punteo);
					         }else {
					        	// System.out.println("Aqui seria si el falso");
					         }
			         
		        	 
		     
		    
		         aux=aux+Punteo;  
		       // System.out.println("Punteo a ingresar"+Punteo);
	        	 this.vaticinioService.UpdateRanking(lista.get(i).getId(),Punteo);
	        	 this.userLigasService.Punteo(lista.get(i).getUsuario().getId(), lista.get(i).getLigasEntity().getId(),aux);
	        	// System.out.println("paso 3");
		       //  System.out.println("paso 6");
		}
		//  System.out.println("UpdateRanking");
		 
		  
      	} catch (Exception e) {
      		System.out.println("error");
			System.out.println(e);
		}
        
		  
		  return true;
	  }
	  
	  
	   	
	
}
