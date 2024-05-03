package com.rabbit.springbootrabbit.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rabbit.springbootrabbit.dto.User;

@Service
public class RabbitJsonProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.json_routing_key.name}")
    private String routingJsonKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitJsonProducer.class);
    private RabbitTemplate rabbitTemplate;

    public RabbitJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMesage(User user) {
        LOGGER.info(String.format("json message sent %s ", user.toString()));
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
    }
    
}
