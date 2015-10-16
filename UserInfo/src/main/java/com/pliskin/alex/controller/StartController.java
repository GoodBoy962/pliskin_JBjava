package com.pliskin.alex.controller;

import com.pliskin.alex.service.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by aleksandrpliskin on 11.10.15.
 */
@Controller
public class StartController {
    @Autowired
    UserImpl user;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/table")
    public String showTable(Model model) {
        if (user.getUserInfo().getName() != null) {
            model.addAttribute("userInfo", user.getUserInfo());
            return "table";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "table", method = RequestMethod.POST)
    public String Submit(@RequestParam("name") String name,
                         @RequestParam("surname") String surname,
                         @RequestParam("thirdName") String thirdName,
                         @RequestParam("date") String date,
                         @RequestParam("sex") String sex) {
        if (sex.isEmpty()) sex = null;
        if (date.isEmpty()) date = null;
        user.addUserInfo(name, surname, thirdName, date, sex);
        return "redirect:/table";
    }

    @RequestMapping("/logout")
    public String logOut() {
        user.getUserInfo().setName(null);
        user.getUserInfo().setSurname(null);
        user.getUserInfo().setSex(null);
        user.getUserInfo().setThirdName(null);
        user.getUserInfo().setDate(null);
        return "redirect:/";
    }

}
