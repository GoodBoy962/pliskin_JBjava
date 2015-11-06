package com.pliskin.controller;

import com.pliskin.model.User;
import com.pliskin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aleksandrpliskin on 30.10.15.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profile")
    public String getProfilePage(Model model) {
        User principal;
        try {
            principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            principal = null;
        }
        model.addAttribute("principal", principal);
        return "profile";
    }

}
