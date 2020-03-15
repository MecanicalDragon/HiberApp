package net.medrag.hiberapp.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/adm1")
    public String request1(){
        return "admin/adminPage";
    }

    @GetMapping("/adm2")
    public String request2(){
        return "admin/adminPage2";
    }
}
