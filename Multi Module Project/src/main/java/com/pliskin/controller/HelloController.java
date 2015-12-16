package com.pliskin.controller;

import com.pliskin.model.HelloModel;
import com.pliskin.service.HelloService;
import com.pliskin.service.HelloServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    private HelloService service = new HelloServiceImpl();

    @RequestMapping("/")
    public String index(Model model) {
        HelloModel helloModel = new HelloModel();
        helloModel.setPhrase("Hello World");
        String phrase = service.sayPhrase(helloModel.getPhrase());
        model.addAttribute("phrase", phrase);
        return "index";
    }
}
