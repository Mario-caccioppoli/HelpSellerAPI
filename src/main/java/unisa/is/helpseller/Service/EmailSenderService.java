/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unisa.is.helpseller.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


/**
 *
 * @author Alex
 */
@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    
    public void sendEmail(String destinatario, String oggetto, String body){
        SimpleMailMessage emailMsg = new SimpleMailMessage();
        emailMsg.setFrom("helpsellerapi@gmail.com");
        emailMsg.setTo(destinatario);
        emailMsg.setText(body);
        emailMsg.setSubject(oggetto);
        
        mailSender.send(emailMsg);
        
        System.out.println("Mail inviata");
    }
}
