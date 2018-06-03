package net.medrag.hiberapp.controller.pub;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("fail")
public class FailController {

    private static Map<String, String> messages;

    static {
        messages = new HashMap<>();
        messages.put("auth", "You have input wrong login or password. Try again.");
    }

    @GetMapping("{act}")
    public String fail(@PathVariable String act, Model model){
        model.addAttribute("msg", messages.get(act));
        return "public/fail";
    }
}
