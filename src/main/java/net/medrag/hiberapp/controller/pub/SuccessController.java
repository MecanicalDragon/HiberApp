package net.medrag.hiberapp.controller.pub;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/success")
public class SuccessController {

    private static Map<String, String> messages;

    static {
        messages = new HashMap<>();
        messages.put("auth", "Authorisation");
        messages.put("logout", "Logout");
        messages.put("reg", "Congratulations! Registration");
        messages.put("conf", "Congratulations again! Confirmation of your email");
    }

    @GetMapping("{act}")
    public String success(@PathVariable String act, Model model, @ModelAttribute("email") String email){
        model.addAttribute("msg", messages.get(act));
        if (email!=null) {
            String mail = String.format("http://%s", email);
            model.addAttribute("mail", mail);
        }
        return "public/success";
    }
}
