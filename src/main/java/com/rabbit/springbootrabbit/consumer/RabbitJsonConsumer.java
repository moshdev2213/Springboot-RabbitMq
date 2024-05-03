package com.rabbit.springbootrabbit.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.rabbit.springbootrabbit.dto.User;

@Service
public class RabbitJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitJsonConsumer.class);

    @RabbitListener(queues={"${rabbitmq.josn_queue.name}"})
    public void consumeJsonMessage(User user) {
        LOGGER.error(String.format("recived message : %s",user.toString()));
    }
}
