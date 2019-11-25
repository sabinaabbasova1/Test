package com.example.sendemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Service
public class SendEmail {
    private  JavaMailSender javaMailSender;
    @Autowired
    public SendEmail(@Qualifier("getJavaMailSender") JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }    
    @Scheduled(fixedDelay = 1000)
    void sendEmail() {
        System.out.println("mail sender");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("sabbasova01@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);
        System.out.println("send successfully");
    }
}
