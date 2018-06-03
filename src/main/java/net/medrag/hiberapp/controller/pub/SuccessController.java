package net.medrag.hiberapp.controller.pub;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("success")
public class SuccessController {

    private static Map<String, String>messages;

    static {
        messages = new HashMap<>();
        messages.put("auth", "Authorisation");
    }

    @GetMapping("{act}")
    public String success(@PathVariable String act, Model model){
        model.addAttribute("msg", messages.get(act));
        return "public/success";
    }
}

//    @GetMapping("{act}")
//    public ModelAndView success(@PathVariable String act){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("msg", messages.get(act));
//        mav.setViewName("public/success");
//        return mav;
//    }