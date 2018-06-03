package net.medrag.hiberapp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("usr1")
public class UserPageController1 {


    @GetMapping
    public String request(){
        return "user/userPage";
    }
}
