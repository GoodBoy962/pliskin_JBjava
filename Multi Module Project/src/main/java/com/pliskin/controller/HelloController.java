package com.pliskin.controller;

import com.pliskin.service.HelloService;
import com.pliskin.service.HelloServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    private HelloService service = new HelloServiceImpl();

    @RequestMapping("/")
    public String index(Model model) {
//        HelloModel helloModel = new HelloModel();
//        helloModel.setPhrase("Hello World");
//        String phrase = service.sayPhrase(helloModel.getPhrase());
        service.setPhrase("Hello World");
        String phrase = service.sayPhrase();
        model.addAttribute("phrase", phrase);
        return "index";
    }

    @RequestMapping("/{phrase}")
    public String phrase(Model model, @PathVariable("phrase") String phrase) {
        service.setPhrase(phrase);
        model.addAttribute("phrase", service.sayPhrase());
        return "phrase";
    }
}
