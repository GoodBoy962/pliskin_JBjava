package com.pliskin.service;

import com.pliskin.form.UserRegistrationForm;
import com.pliskin.model.User;

import java.util.List;

public interface UserService {

    boolean saveNewUser(UserRegistrationForm form);

    void securedMethod();

    List<User> findAll();

    boolean containsUser(String username);

}
