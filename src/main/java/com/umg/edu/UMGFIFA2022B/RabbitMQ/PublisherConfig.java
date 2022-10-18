package com.umg.edu.UMGFIFA2022B.RabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;


@Configuration
public class PublisherConfig {

	@Value("${UmgFifa.queue.name}")
	private String message;
	
	@Bean
	public Queue queeu() {
		return new Queue(message,true);
	}
	
}
