package com.pliskin.service.impl;


import com.pliskin.repository.ScoresRepository;
import com.pliskin.repository.StudentsRepository;
import com.pliskin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by aleksandrpliskin on 14.10.15.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private ScoresRepository scoresRepository;

    @Override
    public Integer getTotal(String name, String surname, String lastname) {
        try {
            return scoresRepository.getTotal(studentsRepository.getId(name, surname, lastname));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public BigDecimal getAverage(String name, String surname, String lastname) {
        try {
            return scoresRepository.getAverage(studentsRepository.getId(name, surname, lastname));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Integer getCurrentSubjectPoints(String name, String surname, String lastname, String subject) {
        try {
            return scoresRepository.getCurrentSubject(studentsRepository.getId(name, surname, lastname), subject);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
