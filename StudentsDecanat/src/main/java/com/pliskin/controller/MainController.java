package com.pliskin.controller;

import com.pliskin.service.AddUsersRepository;
import com.pliskin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Created by aleksandrpliskin on 14.10.15.
 */
@Controller
public class MainController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/main")
    public String getMainPage() {
        return "main";
    }

    @RequestMapping("/total")
    public String getTotal(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String thirdname,
            Model model
    ) {
        Integer result1 = studentService.getTotal(name, surname, thirdname);
        if (result1 == null) {
            model.addAttribute("error1", "Нет  такого студента");
            return "main";
        } else {
            model.addAttribute("result1", studentService.getTotal(name, surname, thirdname));
            return "total";
        }
    }

    @RequestMapping("/average")
    public String getAverage(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String thirdname,
            Model model
    ) {
        BigDecimal result2 = studentService.getAverage(name, surname, thirdname);
        if (result2 == null) {
            model.addAttribute("error2", "Нет  такого студента");
            return "main";
        } else {

            model.addAttribute("result2", result2.doubleValue());
            return "average";
        }
    }

    @RequestMapping("/current-subject")
    public String getCurrentSubjectPoints(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String thirdname,
            @RequestParam String subject,
            Model model
    ) {
        Integer result3 = studentService.getCurrentSubjectPoints(name, surname, thirdname, subject);
        if (result3 == null) {
            model.addAttribute("error3", "Нет  такого студента или у этого студента нет такого предмета");
            return "main";
        } else {
            model.addAttribute("result3", result3);
            return "current-subject";
        }
    }
}
