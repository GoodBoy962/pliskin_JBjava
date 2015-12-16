package com.pliskin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import com.pliskin.service.Service;
import org.springframework.ui.Model;

@Controller
public class HelloController {

//    @Autwired
    private Service service = new SomeServiceImpl();

    @RequestMapping("/")
    public String greeting(Model model) {
        SomeModel model = new SomeModel(service.greeting());
        model.addAttribute("greeting", model.getSpeech());
        return "index";
    }

}
