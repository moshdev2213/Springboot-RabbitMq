package com.rabbit.springbootrabbit.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducer {
    // fetch from application.properties
    @Value("${rabbitmq.routing_key.name}")
    private String routingKey;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitProducer.class);
    private RabbitTemplate rabbitTemplate;

    public RabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("message sent : %s", message));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
