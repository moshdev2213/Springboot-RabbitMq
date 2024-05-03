package com.rabbit.springbootrabbit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.springbootrabbit.dto.User;
import com.rabbit.springbootrabbit.publisher.RabbitJsonProducer;
import com.rabbit.springbootrabbit.publisher.RabbitProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    @Autowired
    private RabbitProducer rabbitProducer;
    @Autowired
    private RabbitJsonProducer rabbitJsonProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitProducer.sendMessage(message);
        return ResponseEntity.ok("message sent to rabbitmq");
    }

    @PostMapping("/sendjson")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        rabbitJsonProducer.sendJsonMesage(user);
        return ResponseEntity.ok("json message sent to RabbitMq");
    }    
}
