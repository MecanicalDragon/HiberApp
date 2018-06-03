//package net.medrag.hiberapp.controller;
//
//import net.medrag.hiberapp.model.domain.Role;
//import net.medrag.hiberapp.model.domain.User;
//import net.medrag.hiberapp.model.service.SecurityService;
//import net.medrag.hiberapp.model.service.UserService;
//import net.medrag.hiberapp.model.validator.UserValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//@Controller
//public class UserController {
//
//    private UserService userService;
//
//    private SecurityService securityService;
//
//    private UserValidator userValidator;
//
//    @Autowired
//    @Qualifier("securityService")
//    public void setSecurityService(SecurityService securityService) {
//        this.securityService = securityService;
//    }
//
//    @Autowired
//    @Qualifier("userService")
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Autowired
//    @Qualifier("userValidator")
//    public void setUserValidator(UserValidator userValidator) {
//        this.userValidator = userValidator;
//    }
//
//    @RequestMapping(value = "/loginDone", method = RequestMethod.POST)
//    public String loginDone(@RequestParam String username,
//                            @RequestParam String password,
//                            Model model){
//        User authorizedUser = userService.getUserByNameAndPass(username, password);
//        if (authorizedUser!=null){
//            System.out.println("You signed in as a:");
//            System.out.println(authorizedUser);
//            model.addAttribute("msg", "Authorisation");
//            return "success";
//        }
//        model.addAttribute("msg", "You have input wrong login or password. Try again.");
//        return "fail";
//    }
//
//    @RequestMapping(value = "/registrationDone", method = RequestMethod.POST)
//    public String registrationDone(@RequestParam String username,
//                                   @RequestParam String email,
//                                   @RequestParam String password,
//                                   @RequestParam String passwordConfirm,
//                                   Model model){
//        if (!password.equals(passwordConfirm)){
//            model.addAttribute("msg", "Passwords are not equal. Try again.");
//            return "fail";
//        } else {
//            if (userService.getUserByName(username)!=null){
//                model.addAttribute("msg", "User with this login already exists. Choose another login.");
//                return "fail";
//            } else {
//                if (userService.getUserByEmail(email)!=null){
//                    model.addAttribute("msg", "There already exists an account, registered to this email. We can't let you create another one, sorry :)");
//                    return "fail";
//                }
//            }
//        }
//
//        User newUser = new User();
//        newUser.setEmail(email);
//        newUser.setUsername(username);
//        newUser.setPassword(password);
//        newUser.setRole(Role.ROLE_USER);
//        userService.addUser(newUser);
//        newUser = userService.getUserByNameAndPass(username, password);
//        System.out.println("You signed in as a:");
//        System.out.println(newUser);
//        model.addAttribute("msg", "Congratulations! Registration" );
//        return "success";
//    }
//
//}
