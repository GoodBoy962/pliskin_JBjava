package com.pliskin.service;

import org.springframework.stereotype.Service;
import com.pliskin.form.UserRegistrationForm;

public interface UserService {

    boolean saveNewUser(UserRegistrationForm form);

    void securedMethod();

}
