package net.medrag.hiberapp.model.validator;

import net.medrag.hiberapp.model.domain.User;
import net.medrag.hiberapp.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Locale;

@Component
public class UserValidator implements Validator {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required.Field");
        if (user.getUsername().length() < 4 || user.getUsername().length() > 16) {
            errors.rejectValue("username", "Username.Size");
        }

        if (userService.getUserByName(user.getUsername()) != null) {
            errors.rejectValue("username", "User.Exists");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required.Field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required.Field");

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Short.Password");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "Passwords.Equal");
        }

    }
}
