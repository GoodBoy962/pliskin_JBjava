package com.pliskin.controller;

import com.pliskin.model.Post;
import com.pliskin.model.User;
import com.pliskin.service.PostService;
import com.pliskin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by aleksandrpliskin on 31.10.15.
 */
@Controller
public class PostController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @RequestMapping("profile/post/add")
    @ResponseStatus(HttpStatus.OK)
    public void addTweet(@RequestParam("text") String text) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.savePost(user, text);
    }

    @RequestMapping("profile/post/getAll")
    public String getAllTweetsPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Post> posts = postService.getAll(user);
        model.addAttribute("posts", posts);
        return "postsList";
    }

    @RequestMapping(value = "/friend/{username}/post/add")
    public void addPostOnOtherUserPage(Model model, @PathVariable("username") String friend, String text) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.savePost(user, friend, text);
    }

    @RequestMapping("/friend/{username}/post/getAll")
    public String getAllTweetsPage(Model model, @PathVariable("username") String friend) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Post> posts = postService.getAll(friend);
        model.addAttribute("posts", posts);
        return "postsList";
    }

}