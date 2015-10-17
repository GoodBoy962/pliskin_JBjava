package com.pliskin.controller;

import com.pliskin.model.Scores;
import com.pliskin.model.Student;
import com.pliskin.service.AddUsersRepository;
import com.pliskin.service.StudentService;
import com.pliskin.util.FormValodator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Created by aleksandrpliskin on 14.10.15.
 */
@Controller
public class MainController {
    @Autowired
    StudentService studentService;

    FormValodator validator = new FormValodator();

    @RequestMapping("/main")
    public String getMainPage() {
        return "main";
    }

    @RequestMapping(value = "/total", method = RequestMethod.GET)
    public String getTotal(
            @ModelAttribute Student student, BindingResult result,
            Model model
    ) {
        validator.validate(student, result);
        Integer result1 = studentService.getTotal(student.getName(), student.getSurname(), student.getThirdName());
        if (result1 == null) {
            model.addAttribute("error1", "Нет  такого студента");
            return "main";
        } else {
            model.addAttribute("result1", result1);
            return "total";
        }
    }

    @RequestMapping(value = "/average", method = RequestMethod.GET)
    public String getAverage(
            @ModelAttribute Student student, BindingResult result,
            Model model
    ) {
        validator.validate(student, result);
        BigDecimal result2 = studentService.getAverage(student.getName(), student.getSurname(), student.getThirdName());
        if (result2 == null) {
            model.addAttribute("error2", "Нет  такого студента");
            return "main";
        } else {

            model.addAttribute("result2", result2.doubleValue());
            return "average";
        }
    }

    @RequestMapping(value = "/current-subject", method = RequestMethod.GET)
    public String getCurrentSubjectPoints(
            @ModelAttribute Student student, BindingResult result,
            @ModelAttribute Scores scores,
            Model model
    ) {
        validator.validate(student, result);
        Integer result3 = studentService.getCurrentSubjectPoints(student.getName(), student.getSurname(), student.getThirdName(), scores.getSubject());
        if (result3 == null) {
            model.addAttribute("error3", "Нет  такого студента или у этого студента нет такого предмета");
            return "main";
        } else {
            model.addAttribute("result3", result3);
            return "current-subject";
        }
    }
}
