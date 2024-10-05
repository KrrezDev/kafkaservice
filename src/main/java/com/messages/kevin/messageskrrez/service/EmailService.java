package com.messages.kevin.messageskrrez.service;

import com.messages.kevin.messageskrrez.model.ContactMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author Kevin
 */
@Service
public class EmailService {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendEmail(ContactMessage contactMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@tuportfolio.com");
        message.setTo("krrez.contact@gmail.com");
        message.setSubject("Nuevo mensaje de contacto de " + contactMessage.getName());
        message.setText("Nombre: " + contactMessage.getName() + "\n" +
                "Email: " + contactMessage.getEmail() + "\n" +
                "Mensaje: " + contactMessage.getMessage());
        emailSender.send(message);
    }
}