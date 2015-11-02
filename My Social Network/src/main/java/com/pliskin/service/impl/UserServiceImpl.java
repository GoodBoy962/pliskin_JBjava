package com.pliskin.service.impl;

import com.pliskin.form.UserRegistrationForm;
import com.pliskin.model.User;
import com.pliskin.repository.UserRepository;
import com.pliskin.service.UserService;
import com.pliskin.util.UserRegistrationFormToUserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aleksandrpliskin on 29.10.15.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Qualifier("userRepository")
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean saveNewUser(UserRegistrationForm form) {
        System.out.println(form.getUsername());
        User user = UserRegistrationFormToUserTransformer.transform(form);
        if (user != null) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Secured("hasRole('ROLE_ADMIN')")
    @Override
    public void securedMethod() {

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


}
