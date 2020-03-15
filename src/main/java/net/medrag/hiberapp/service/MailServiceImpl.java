package net.medrag.hiberapp.service;

import net.medrag.hiberapp.model.RawUser;
import net.medrag.hiberapp.service.api.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class MailServiceImpl implements MailService {

    private JavaMailSender mailSender;

    private Boolean useEmail;

    public void setUseEmail(Boolean useEmail) {
        this.useEmail = useEmail;
    }

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
        message.addRecipients(Message.RecipientType.TO, email);
        message.setSubject("Please, confirm your registration in My Web App");
        String link = String.format("http://%s:%s/register/confirm/%s",
                properties.get("server.address"),
                properties.get("server.http.port"),
                confirmCode);
        String text = String.format("To confirm your registration, please, follow the next link: \n %s" +
                "\n(Or triple click on it, copy and paste in your browser's address form," +
                " if your mail provider hasn't recognized it).", link);
        message.setText(text);
        if (useEmail)
            mailSender.send(message);
        else System.out.println(text);
    }

    @Override
    public void sendUsersDataEmail(RawUser user) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        message.addRecipients(Message.RecipientType.TO, user.getEmail());
        message.setSubject("Successful registration in My Web App");
        String text = String.format("We congratulate you with successful registration in My Web App! \n" +
                "Your login: %s \n" +
                "Your email: %s \n" +
                "Your password: %s \n" +
                "You have no need to answer this email.", user.getUsername(), user.getEmail(), user.getPassword());
        message.setText(text);
        if (useEmail)
            mailSender.send(message);
        else System.out.println(text);
    }
}
