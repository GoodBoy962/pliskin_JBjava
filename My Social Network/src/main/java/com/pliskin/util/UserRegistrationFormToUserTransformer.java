package com.pliskin.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.pliskin.form.UserRegistrationForm;
import com.pliskin.model.User;
import com.pliskin.model.enums.UserRole;

public class UserRegistrationFormToUserTransformer {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static User transform(UserRegistrationForm form) {
        if (form == null) {
            return null;
        }
        User user = new User();
        user.setUsername(form.getUsername());
        user.setRole(UserRole.ROLE_USER);
        user.setPassword(encoder.encode(form.getPassword()));
        return user;
    }
}
