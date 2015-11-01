package com.pliskin.controller;

import com.pliskin.model.Post;
import com.pliskin.model.User;
import com.pliskin.repository.UserRepository;
import com.pliskin.service.PostService;
import com.pliskin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by aleksandrpliskin on 31.10.15.
 */
@Controller
public class FriendsController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

//    @Autowired
//    UserRepository userRepository;

    @RequestMapping(value = "/profile/all_users")
    public String getAllUsers(Model model) {
        List<User> users = userService.findAll();
//        System.out.println(users);
//        List<User> users1, users2;
//        User user = userRepository.findOneByUsername(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
//        System.out.println(user.getUsername());
//        System.out.println(users.indexOf(userRepository.findOneByUsername(user.getUsername())));
//        users1 = users.subList(0, users.indexOf((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
//        users2 = users.subList(users.indexOf((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()), users.size());
//        users1.addAll(users2);
        model.addAttribute("users", users);
        return "all-user";
    }

    @RequestMapping(value = "/friend/{username}", method = RequestMethod.GET)
    public String getOtherProfilePage(Model model, @PathVariable("username") String friend) {
        //System.out.println(friend);
        model.addAttribute("friend", friend);
        return "friend";
    }

}
