package net.medrag.hiberapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

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
        Properties properties = new Properties();
        try {
        URL url = getClass().getResource("/server.properties");
        Path path = Paths.get(url.toURI());
            properties.load(new FileInputStream(path.toFile()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            throw new MessagingException("Can not load server.properties.");
        }
        message.setFrom(new InternetAddress("medragwebapp@gmail.com"));
        message.addRecipients(Message.RecipientType.TO, email);
        message.setSubject("Please, confirm your registration in My Web App");
        String link = String.format("http://%s:%s/register/confirm/%s",
                properties.get("server.address"),
                properties.get("server.http.port"),
                confirmCode);
        message.setText("To confirm your registration, please, follow the next link: \n"+link +
        "\n(Or triple click on it, copy and paste in your browser's address form, if your mail provider hasn't recognized it)");
        mailSender.send(message);
    }
}
