package com.ysrbdlgn.spring.webapp.domain.validator;

import com.ysrbdlgn.spring.webapp.domain.User;
import com.ysrbdlgn.spring.webapp.domain.UserAddForm;
import com.ysrbdlgn.spring.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.validation.Validator;

@Component
public class RegisterValidator implements org.springframework.validation.Validator {

    private final UserService userService;

    @Autowired
    public RegisterValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserAddForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserAddForm form = (UserAddForm) o;
        validateUsername(errors, form);
    }

    private void validateUsername(Errors errors, UserAddForm form) {
        if (userService.getUserByUsername(form.getUsername()) != null) {
            errors.reject("username.exists", "User with this username already exists");
        }
    }
}
