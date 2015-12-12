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
    private UserService userService;

    @Autowired
    private PostService postService;

    @RequestMapping("profile/post/add")
    @ResponseStatus(HttpStatus.OK)
    public void addPost(@RequestParam("text") String text) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.savePost(user, text);
    }

    @RequestMapping("profile/post/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@RequestParam("post") Post post) {
        postService.deletePost(post);
    }

    @RequestMapping("profile/post/getAll")
    public String getAllPostsPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Post> posts = postService.getAll(user);
        User principal;
        try {
            principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            principal = null;
        }
        model.addAttribute("principal", principal);
        model.addAttribute("posts", posts);
        return "postsList";
    }

    @RequestMapping(value = "friend/post/add")
    @ResponseStatus(HttpStatus.OK)
    public void addPostOnOtherUserPage(Model model, String friend, String text) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.savePost(user, friend, text);
    }

    @RequestMapping("friend/post/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deletePostOnOtherUserPage(@RequestParam("post") Post post) {
        postService.deletePost(post);
    }

    @RequestMapping("friend/post/getAll")
    public String getAllPostsPage(Model model, String friend) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Post> posts = postService.getAll(friend);
        User principal;
        try {
            principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            principal = null;
        }
        model.addAttribute("principal", principal);
        model.addAttribute("posts", posts);
        return "postsList";
    }

}
