package net.medrag.hiberapp.controller.pub;

import net.medrag.hiberapp.model.domain.Role;
import net.medrag.hiberapp.model.domain.User;
import net.medrag.hiberapp.model.service.SecurityService;
import net.medrag.hiberapp.model.service.UserService;
import net.medrag.hiberapp.model.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("register")
public class RegistrationController {

    private UserService userService;

    private SecurityService securityService;

    private UserValidator userValidator;

    @Autowired
    @Qualifier("securityService")
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier("userValidator")
    public void setValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @GetMapping()
    public String register(Model model){
        model.addAttribute("user", new User());
        return "public/register";
    }

    @PostMapping
    public String registrationDone(@ModelAttribute("user") User user, BindingResult bindingResult){

        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "public/register";
        }

        user.setRole(Role.ROLE_USER);
        userService.addUser(user);
        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());

        return "redirect:success/reg";
    }
}
