package com.pliskin.controller;

import com.pliskin.service.PostService;
import com.pliskin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aleksandrpliskin on 31.10.15.
 */
@Controller
public class FriendsController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/profile/all_users")
    public String getAllUsers(Model model) {
        model.addAttribute("users",userService.findAll());
        return "all-user";
    }

}
