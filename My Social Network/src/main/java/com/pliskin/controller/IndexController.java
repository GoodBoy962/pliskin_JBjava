package com.pliskin.controller;

import com.pliskin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String getIndexPage() {
        return "index";
    }


}
