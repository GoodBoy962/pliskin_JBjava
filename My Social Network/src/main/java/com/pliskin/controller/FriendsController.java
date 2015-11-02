package com.pliskin.controller;

import com.pliskin.model.User;
import com.pliskin.service.PostService;
import com.pliskin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class FriendsController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @RequestMapping(value = "/profile/all_users")
    public String getAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "all-user";
    }

    @RequestMapping(value = "/friend/{username}", method = RequestMethod.GET)
    public String getOtherProfilePage(Model model, @PathVariable("username") String friend) {
        User principal;
        try {
            principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            principal = null;
        }
        model.addAttribute("principal", principal);
        model.addAttribute("friend", friend);
        return "friend";
    }
}
