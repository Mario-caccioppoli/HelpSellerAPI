/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unisa.is.helpseller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import unisa.is.helpseller.Service.EmailSenderService;

/**
 *
 * @author Alex
 */
//@SpringBootApplication    per farlo partire togliere il commento
public class inviaMail {
    @Autowired
    private EmailSenderService senderService;
    
    public static void main(String[] args) {
        SpringApplication.run(inviaMail.class, args);
    }
    
    @EventListener(ApplicationReadyEvent.class)
    public void sendMail(){
        senderService.sendEmail("xlitsl0l@gmail.com", "email", "testo");
    }
}
