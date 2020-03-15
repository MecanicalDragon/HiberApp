package net.medrag.hiberapp.service.api;

import net.medrag.hiberapp.model.RawUser;

import javax.mail.MessagingException;

public interface MailService {
    void sendConfirmEmail(String email, String confirmCode) throws MessagingException;

    void sendUsersDataEmail(RawUser user) throws MessagingException;
}
