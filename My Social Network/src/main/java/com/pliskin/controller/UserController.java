package com.pliskin.controller;

import com.pliskin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Pattern;

/**
 * Created by aleksandrpliskin on 30.10.15.
 */
@Controller
public class UserController {

    Pattern pattern = Pattern.compile("/profile[?].+");

    @Autowired
    UserService userService;

    @RequestMapping(value = "/profile")
    public String getProfilePage(Model model) {
        return "profile";
    }

}
