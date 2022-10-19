package com.umg.edu.UMGFIFA2022B.RabbitMQ;

import java.util.Date;

import org.hibernate.query.criteria.internal.expression.EntityTypeExpression;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.umg.edu.UMGFIFA2022B.TSecurity.Entity.Usuario;
import com.umg.edu.UMGFIFA2022B.TSecurity.Repository.UsuarioRepository;
import com.umg.edu.UMGFIFA2022B.entity.LigasEntity;
import com.umg.edu.UMGFIFA2022B.entity.PartidoEntity;
import com.umg.edu.UMGFIFA2022B.entity.UserEntity;
import com.umg.edu.UMGFIFA2022B.entity.VaticinioAuxEntity;
import com.umg.edu.UMGFIFA2022B.entity.VaticinioEntity;
import com.umg.edu.UMGFIFA2022B.repository.LigasRepository;
import com.umg.edu.UMGFIFA2022B.repository.PartidosRepository;
import com.umg.edu.UMGFIFA2022B.repository.VaticinioRepository;
import com.umg.edu.UMGFIFA2022B.services.VaticinioService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RabbitConsumidor {
	@Autowired
	private VaticinioService vaticinioService;
	@Autowired
	private   LigasRepository ligasRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PartidosRepository partidosRepository;
	
	Long re=(long) 1;
	
	
	@RabbitListener(queues= {"${UmgFifa.queue.name}"})
	public void receive(@Payload VaticinioAuxEntity message) {
		VaticinioEntity rt=new VaticinioEntity();
		Usuario user= new Usuario();
		LigasEntity liga =new LigasEntity();
		PartidoEntity partido=new PartidoEntity();
		log.info("mensaje Recibido",message);
		System.out.println("Paso 1");
		
		if(message!=null) { 
			try {
				System.out.println("Paso 2 mensaje lleno");
				rt.setId(re);
			 rt.setPartido(message.getPartido());
			 rt.setNombre(message.getNombre());
			 rt.setVat1(message.getVat1());
			 rt.setVat2(message.getVat2());
			 rt.setPunteo(message.getPunteo());
			 liga=ligasRepository.findById(message.getIDLiga()).orElseThrow();
			 rt.setLigasEntity(liga);
			 user=usuarioRepository.findById(message.getIDUser()).orElseThrow();
			 rt.setUsuario(user);
			 partido=partidosRepository.findById(message.getIDPartido()).orElseThrow();
			 rt.setPartidoEntity(partido);
			 rt.setCreateDate(message.getCreateDate());
			vaticinioService.save(rt);
			
			System.out.println("Mensaje Lleno   " +rt.toString());
			re++;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Datos Incorrectos");
				System.out.println("Mensaje ERROR" +rt.toString());
			}
			
		}else {
			System.out.println("mensaje Vacio");
		}
	
		makeSlow();
	}
	private void  makeSlow() {
		try {
			System.out.println("Paso 5 tiempo");
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
