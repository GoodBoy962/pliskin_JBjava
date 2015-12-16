package com.pliskin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.Model;
import com.pliskin.model.HelloModel;
import com.pliskin.service.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    private HelloService service = new HelloServiceImpl();

    @RequestMapping("/")
    public String index(Model model) {
        HelloModel string = new HelloModel();
        model.addAttribute("greeting", string.getPhrase());
        return "index";
    }

}
