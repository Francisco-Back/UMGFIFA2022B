package com.umg.edu.UMGFIFA2022B.util;

import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.umg.edu.UMGFIFA2022B.entity.PartidoEntity;
import com.umg.edu.UMGFIFA2022B.services.PartidosService;

@Component
public class CreatePartidos implements CommandLineRunner {
	 
	 @Autowired
	 PartidosService partidosService;
	 

	 @Override
     public void run(String... args) throws Exception{
		 
		 
		
		 
		 JSONParser parser = new JSONParser();
		 PartidoEntity partidoEntity=new PartidoEntity();
		 
	        FileReader reader = new FileReader("umg2022fifaPartidos.json");
	        Object obj = parser.parse(reader);
	        JSONObject pJsonObj = (JSONObject)obj;
	        JSONArray array = (JSONArray)pJsonObj.get("Partidos");
	      for(int i=0; i<array.size(); i++) {
	    	  JSONObject Partidos = (JSONObject)array.get(i);
	    	  System.out.println(Partidos);
	    	   System.out.println("Ingres Bucle"+i);
	    	   String Pais2=(String) Partidos.get("Pais2");
	    	    String Pais1=(String) Partidos.get("Pais1");
	    	    int Marcador2 = Integer.parseInt((String) Partidos.get("Marcador2"));
	    	    int Marcador1 = Integer.parseInt((String) Partidos.get("Marcador1"));
	    	    String AM= (String) Partidos.get("AM");
	    	    int Jornada= Integer.parseInt( (String) Partidos.get("Jornada "));
	    	    String Fecha=(String) Partidos.get("Fecha");
	    	    long ID=  Long.parseLong(  (String) Partidos.get("ID"));
	    	    String Bandera2=(String) Partidos.get("Bandera2");
	    	    String Horario=(String) Partidos.get("Horario");
	    	    String Bandera1=(String) Partidos.get("Bandera1");
	    	    String Grupos=(String) Partidos.get("Grupos");
	    	    String Tamaño=(String) Partidos.get("Tamaño");
	    	    String Columna=(String) Partidos.get("Columna");
	    	   
	    	    partidoEntity.setID(ID);
	    	    partidoEntity.setPais1(Pais1);
	    	    partidoEntity.setPais2(Pais2);
	    	    partidoEntity.setMarcador1(Marcador1);
	    	    partidoEntity.setMarcador2(Marcador2);
	    	    partidoEntity.setAm(AM);
	    	    partidoEntity.setJornada(Jornada);
	    	    partidoEntity.setFecha(Fecha);
	    	    partidoEntity.setBandera2(Bandera2);
	    	    partidoEntity.setHorario(Horario);
	    	    partidoEntity.setBandera1(Bandera1);
	    	    partidoEntity.setGrupos(Tamaño);
	    	    partidoEntity.setColumna(Columna);
	    	  
 			   System.out.println("Numero "+i);
 			   System.out.println(partidoEntity.toString());
 			   
 			   partidosService.save(partidoEntity);
	    	  //rolService.save(rolAdmin);
	    	 /* "ID": 1,
	          "Marcador1": 0,
	          "Marcador2":0,
	         "AM": "am",
	         "Bandera1": "https://flagcdn.com/sn.svg",
	         "Bandera2": "https://flagcdn.com/nl.svg",
	         "Columna": "ID1",
	         "Fecha": "21/11/2022",
	         "Grupos ": "Grupos A",
	         "Horario": "04:00",
	         "Jornada ": 1,
	         "Pais1": "Senegal",
	         "Pais2": "Países Bajos",
	         "Tamaño": "A"
	        	 */
	      }
	      System.out.println("Fin del ciclo");
	 }
	 
	 
}
