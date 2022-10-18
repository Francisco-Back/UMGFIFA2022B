package com.umg.edu.UMGFIFA2022B.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;

@Component
@EnableRabbit
public class RabbitProductor {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private Queue queue;
	
	public void send(Object message) {
		rabbitTemplate.convertAndSend(queue.getName(),message);
	}


}
