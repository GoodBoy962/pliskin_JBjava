package com.pliskin.util;


import com.pliskin.form.UserRegistrationForm;
import com.pliskin.model.User;
import com.pliskin.model.enums.UserRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserRegistrationFormToUserTransformer {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public static User transform(UserRegistrationForm form) {
        if (UserRegistrationValidator.registrationDataCorrectness(form)) {
            if (form == null) {
                return null;
            }
            User user = new User();
            user.setUsername(form.getUsername());
            user.setRole(UserRole.ROLE_USER);
            user.setPassword(encoder.encode(form.getPassword()));
            user.setEmail(form.getEmail());
            return user;
        }
        return null;
    }
}
