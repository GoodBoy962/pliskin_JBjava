package com.pliskin.util;

import com.pliskin.form.UserRegistrationForm;
import com.pliskin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

public class UserRegistrationValidator implements Validator {

    @Autowired
    UserRepository userRepository;

    public static boolean registrationDataCorrectness(UserRegistrationForm form) {

        return (form.getEmail().matches(".+@.+") && form.getUsername() != "" && form.getPassword() != "" && form.getPassword().equals(form.getRepassword()));
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegistrationForm form = (UserRegistrationForm) o;

        boolean bool1 = false;
        boolean bool2 = false;

        try {
            userRepository.findOneByUsername(form.getUsername());
        } catch (NullPointerException e) {
            bool1 = true;
        }
        try {
            userRepository.findOneByEmail(form.getEmail());
        } catch (NullPointerException e) {
            bool2 = true;
        }

        if (bool1) {
            errors.rejectValue("username", "такое имя уже существует");
        }
        if (bool2) {
            errors.rejectValue("email", "пользователь с таким e-mail уже существует");
        }
        if (!form.getEmail().matches(".+@.+")) {
            errors.rejectValue("email", "невалидный e-mail");
        }
        if (form.getPassword() != form.getRepassword()) {
            errors.rejectValue("repassword", "ебать ты лох");
        }
        if (form.getPassword().length() < 6 && form.getPassword().length() > 32) {
            errors.rejectValue("password", "невалидный пароль");
        }
    }
}
