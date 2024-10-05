package com.messages.kevin.messageskrrez.controller;

import com.messages.kevin.messageskrrez.model.ContactMessage;
import com.messages.kevin.messageskrrez.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling contact messages.
 * Sends messages to Kafka for processing.
 * 
 * Author: Kevin
 */
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public ContactController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody ContactMessage message) {
        kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("Mensaje recibido y enviado a procesar");
    }
}