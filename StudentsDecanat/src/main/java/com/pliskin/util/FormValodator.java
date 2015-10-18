package com.pliskin.util;

import com.pliskin.model.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by aleksandrpliskin on 17.10.15.
 */
public class FormValodator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        if (student.getName() == null || student.getName().isEmpty()) {
            errors.rejectValue("name", "", "Имя не может быть пустым");
        }
        if (student.getSurname() == null || student.getSurname().isEmpty()) {
            errors.rejectValue("surname", "", "Фамилия не может быть пустой");
        }
        if (student.getThirdName() == null || student.getThirdName().isEmpty()) {
            errors.rejectValue("thirdName", "", "Отчество не может быть пустым");
        }
    }
}
