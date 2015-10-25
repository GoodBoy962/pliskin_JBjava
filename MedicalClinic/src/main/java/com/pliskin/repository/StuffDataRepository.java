package com.pliskin.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by aleksandrpliskin on 18.10.15.
 */
public interface StuffDataRepository {
    BigDecimal findByMedClinic(String name);

    Integer findByMedClinicAndFio(String name, String fio);

    List<String> getByMedClinicFios(String name);

    Date getEmploymentDate(String name, String fio);

    Date getDismissalDate(String name, String fio);

}
