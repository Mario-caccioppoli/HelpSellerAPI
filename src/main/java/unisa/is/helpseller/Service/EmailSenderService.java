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
 * classe per l'invio di una mail di posta elettronica
 *
 */
@Service
public class EmailSenderService {
    public static EmailSenderService istance = null;
    private JavaMailSender mailSender;

    private EmailSenderService(){}

    public static EmailSenderService getInstance(){
        if(istance == null)
            istance = new EmailSenderService();
        return istance;
    }

    /**
     * Metodo per l'invio della mail
     * @param destinatario indirizzo mail del destinatario
     * @param oggetto oggetto della mail
     * @param body corpo della mail
     */
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
