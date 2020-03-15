package net.medrag.hiberapp.service;

import net.medrag.hiberapp.model.RawUser;
import net.medrag.hiberapp.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return RawUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RawUser user = (RawUser) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required.field");

        if (user.getUsername().length() < 4 || user.getUsername().length() > 16) {
            errors.rejectValue("username", "username.size");
        }
        if (userService.getUserByName(user.getUsername()) != null) {
            errors.rejectValue("username", "user.exists");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.field");
        if (userService.getUserByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "email.exists");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.field");
        if (user.getPassword().length() < 3 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "short.password");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "passwords.equal");
        }

    }
}
