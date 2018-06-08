package net.medrag.hiberapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService{

    private JavaMailSender mailSender;

    @Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendConfirmEmail(String email, String confirmCode) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        message.setFrom(new InternetAddress("medragwebapp@gmail.com"));
        message.addRecipients(Message.RecipientType.TO, email);
        message.setSubject("Please, confirm your registration in My Web App");
        String link = "http://localhost:8080/register/confirm/"+confirmCode;
        message.setText("To confirm your registration, please, follow the next link: \n"+link +
        "\n (Or triple click on it, copy and paste in your browser's address form, if your mail provider hasn't recognized it)");
        mailSender.send(message);
    }
}
