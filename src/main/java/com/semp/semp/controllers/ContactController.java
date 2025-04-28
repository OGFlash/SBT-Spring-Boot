package com.semp.semp.controllers;

import com.semp.semp.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular frontend
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping
    public String sendMail(@RequestBody ContactForm contactForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(contactForm.getEmail());
        message.setTo("andrew.java.testing@gmail.com"); // Your inbox
        message.setSubject("New Contact Form Submission from " + contactForm.getName());
        message.setText(contactForm.getMessage() + " "  + contactForm.getEmail());

        mailSender.send(message);

        return "Email sent successfully";
    }
}
