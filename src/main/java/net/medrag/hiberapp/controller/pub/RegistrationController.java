package net.medrag.hiberapp.controller.pub;

import net.medrag.hiberapp.model.domain.RawUser;
import net.medrag.hiberapp.model.domain.Role;
import net.medrag.hiberapp.model.domain.User;
import net.medrag.hiberapp.model.service.MailService;
import net.medrag.hiberapp.model.service.RawUserService;
import net.medrag.hiberapp.model.service.SecurityService;
import net.medrag.hiberapp.model.service.UserService;
import net.medrag.hiberapp.model.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
@RequestMapping("register")
public class RegistrationController {

    private UserService userService;

    private RawUserService rawUserService;

    private SecurityService securityService;

    private UserValidator userValidator;

    private MailService mailService;

    @Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @Autowired
    public void setRawUserService(RawUserService rawUserService) {
        this.rawUserService = rawUserService;
    }

    @GetMapping()
    public String register(Model model){
        model.addAttribute("user", new RawUser());
        return "public/register";
    }

    @PostMapping
    public String registrationDone(@ModelAttribute("user") RawUser user, BindingResult bindingResult) {

        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "public/register";
        }

        String confirmCode = rawUserService.addUser(user);
        try {
            mailService.sendConfirmEmail(user.getEmail(), confirmCode);
        } catch (MessagingException e) {
            return "redirect:../fail/mail";
        }

        return "redirect:../success/reg";
    }

    @GetMapping("confirm/{code}")
    public String confirmEmail(@PathVariable String code){

        RawUser rawUser = rawUserService.getUserByCode(code);
        User user = new User();
        user.setUsername(rawUser.getUsername());
        user.setPassword(rawUser.getPassword());
        user.setEmail(rawUser.getEmail());
        user.setRole(Role.ROLE_USER);
        userService.addUser(user);
        rawUserService.removeUser(rawUser);
        securityService.autoLogin(rawUser.getUsername(), rawUser.getPassword());
        return "redirect:../../success/conf";
    }

}
