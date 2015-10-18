package com.pliskin.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by aleksandrpliskin on 14.10.15.
 */
@Service
public interface StudentService {
    Integer getTotal(String name, String surname, String lastname);

    BigDecimal getAverage(String name, String surname, String lastname);

    Integer getCurrentSubjectPoints(String name, String surname, String lastname, String subject);

}
