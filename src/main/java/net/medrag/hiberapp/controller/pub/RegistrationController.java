package net.medrag.hiberapp.controller.pub;

import net.medrag.hiberapp.model.RawUser;
import net.medrag.hiberapp.model.Role;
import net.medrag.hiberapp.model.User;
import net.medrag.hiberapp.service.*;
import net.medrag.hiberapp.service.api.MailService;
import net.medrag.hiberapp.service.api.RawUserService;
import net.medrag.hiberapp.service.api.SecurityService;
import net.medrag.hiberapp.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserService userService;
    private RawUserService rawUserService;
    private SecurityService securityService;
    private UserValidator userValidator;
    private MailService mailService;

    @Autowired
    public RegistrationController(UserService userService, RawUserService rawUserService, SecurityService securityService, UserValidator userValidator, MailService mailService) {
        this.userService = userService;
        this.rawUserService = rawUserService;
        this.securityService = securityService;
        this.userValidator = userValidator;
        this.mailService = mailService;
    }

    @GetMapping
    public String register(Model model) {
        model.addAttribute("user", new RawUser());
        return "public/register";
    }

    @PostMapping
    public String registrationDone(@ModelAttribute("user") RawUser user, BindingResult bindingResult, Model model) {

        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "public/register";
        }

        String confirmCode = rawUserService.addUser(user);
        try {
            mailService.sendConfirmEmail(user.getEmail(), confirmCode);
        } catch (MessagingException e) {
            rawUserService.removeUser(user);
            return "redirect:../fail/mail";
        }

        model.addAttribute("email", user.getEmail());
        return "redirect:../success/reg";
    }

    @GetMapping("confirm/{code}")
    public String confirmEmail(@PathVariable String code) {

        RawUser rawUser = rawUserService.getUserByCode(code);
        User user = new User();
        user.setUsername(rawUser.getUsername());
        user.setPassword(rawUser.getPassword());
        user.setEmail(rawUser.getEmail());
        user.setRole(Role.ROLE_USER);
        userService.addUser(user);
        rawUserService.removeUser(rawUser);
        try {
            mailService.sendUsersDataEmail(rawUser);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        securityService.autoLogin(rawUser.getUsername(), rawUser.getPassword());
        return "redirect:../../success/conf";
    }

}
