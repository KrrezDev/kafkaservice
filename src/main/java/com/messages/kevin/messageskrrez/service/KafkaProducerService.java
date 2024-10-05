package com.messages.kevin.messageskrrez.service;

import com.messages.kevin.messageskrrez.model.ContactMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Kevin
 */
@Service
public class KafkaProducerService {

    private static final String TOPIC = "contact-messages";

    private final KafkaTemplate<String, ContactMessage> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, ContactMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ContactMessage message) {
        kafkaTemplate.send(TOPIC, message);
    }
}