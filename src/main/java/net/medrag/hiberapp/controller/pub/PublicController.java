package net.medrag.hiberapp.controller.pub;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    @GetMapping("/dbfs")
    public String dbfs(){
        return "public/DBFS";
    }

    @GetMapping("/403")
    public String accessDenied(){
        return "public/403";
    }

    @GetMapping({"/", "/login"})
    public String login(Model model, String error){
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        return "public/login";
    }
}
