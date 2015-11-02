package com.pliskin.controller;

import com.pliskin.form.UserRegistrationForm;
import com.pliskin.repository.UserRepository;
import com.pliskin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("userform", new UserRegistrationForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userform") @Valid UserRegistrationForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        } else if (userRepository.findOneByUsername(form.getUsername()) != null) {
            model.addAttribute("validatorError", "Такой Логин уже существует");
            return "registration";
        } else if (userRepository.findOneByEmail((form.getEmail())) != null) {
            model.addAttribute("validatorError", "Такой email уже существует");
            return "registration";
        } else if (!form.getPassword().equals(form.getRepassword())) {
            model.addAttribute("validatorError", "Пароль не подтвержден");
            return "registration";
        } else {
            userService.saveNewUser(form);
            return "redirect:/";
        }
    }
}


