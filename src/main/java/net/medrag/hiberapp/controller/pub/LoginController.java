package net.medrag.hiberapp.controller.pub;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/","login"})
public class LoginController {

    @GetMapping()
    public String login(Model model, String error){
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        return "public/login";
    }

}
