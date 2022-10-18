package com.umg.edu.UMGFIFA2022B.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RabbitConsumidor {
	
	@RabbitListener(queues= {"$UmgFifa.queue.name"})
	public void receive(@Payload String message) {
		log.info("mensaje Recibido",message);
		makeSlow();
	}
	private void  makeSlow() {
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
