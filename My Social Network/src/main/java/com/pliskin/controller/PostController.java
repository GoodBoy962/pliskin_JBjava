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
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "profile/post/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@RequestParam("id") String id) {
        postService.deletePost(Long.parseLong(id));
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

    @RequestMapping(value = "friend/post/delete", method = RequestMethod.POST)
    public void deletePostOnOtherUserPage(@RequestParam("id") Long id) {
        postService.deletePost(Long.valueOf(id));
    }

    @RequestMapping("friend/post/getAll")
    public String getAllPostsPage(Model model, String friend) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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

    @RequestMapping(value = "profile/post/change/{postId}", method = RequestMethod.GET)
    public String changePost(Model model, @PathVariable("postId") Long id) {
        User principal;
        try {
            principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            principal = null;
        }
        model.addAttribute("principal", principal);
        model.addAttribute("post", postService.getById(id));
        return "change-post";
    }

    @RequestMapping(value = "profile/post/change/save", method = RequestMethod.GET)
    public String changePostAndSave(Model model,
                                    @RequestParam(value = "postId", required = false) String id,
                                    @RequestParam(value = "postText", required = false) String text) {
        User principal;
        try {
            principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            principal = null;
        }
        postService.changePost(Long.valueOf(id), text);
        model.addAttribute("principal", principal);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/lenta")
    public String getLenta(Model model) {
        User principal;
        try {
            principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            principal = null;
        }
        model.addAttribute("principal", principal);
        model.addAttribute("posts", postService.getAll());
        return "lenta";
    }
}
