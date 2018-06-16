package net.medrag.hiberapp.model.service;

        import net.medrag.hiberapp.model.domain.RawUser;

        import javax.mail.MessagingException;

public interface MailService {
    void sendConfirmEmail(String email, String confirmCode) throws MessagingException;
    void sendUsersDataEmail(RawUser user) throws MessagingException;
}
