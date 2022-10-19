package com.umg.edu.UMGFIFA2022B.RabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;



@Configuration
public class PublisherConfig {

	@Value("${UmgFifa.queue.name}")
	private String message;
	@Value("${spring.rabbitmq.password}")
	private String password;
	@Value("${spring.rabbitmq.username}")
	private String username;

	@Bean
	public Queue queue() {
	//	System.out.println(message + password+username);
		return new Queue(message);
	}
	
}
