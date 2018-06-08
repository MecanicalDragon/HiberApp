package net.medrag.hiberapp.model.service;

        import javax.mail.MessagingException;

public interface MailService {
    void sendConfirmEmail(String email, String confirmCode) throws MessagingException;
}
