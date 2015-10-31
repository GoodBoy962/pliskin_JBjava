package com.pliskin.service;

import com.pliskin.model.User;
import org.springframework.stereotype.Service;
import com.pliskin.form.UserRegistrationForm;

import java.util.List;

public interface UserService {

    boolean saveNewUser(UserRegistrationForm form);

    void securedMethod();

    List<User> findAll();

}
