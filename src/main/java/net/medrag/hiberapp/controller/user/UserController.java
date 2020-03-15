package net.medrag.hiberapp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/usr1")
    public String request1(){
        return "user/userPage";
    }

    @GetMapping("/usr2")
    public String request2(){
        return "user/userPage2";
    }
}
