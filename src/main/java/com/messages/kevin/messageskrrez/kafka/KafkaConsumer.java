package com.messages.kevin.messageskrrez.kafka;

import com.messages.kevin.messageskrrez.model.ContactMessage;
import com.messages.kevin.messageskrrez.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Kevin
 */
@Component
public class KafkaConsumer {

    private final EmailService emailService;

    @Autowired
    public KafkaConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "contact-messages", groupId = "contact-group")
    public void listen(ContactMessage message) {
        System.out.println("Recibido mensaje de contacto: " + message);
        emailService.sendEmail(message);
    }
}