package net.medrag.hiberapp.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("adm1")
public class AdmPageController1 {


    @GetMapping
    public String request(){
        return "admin/adminPage";
    }
}