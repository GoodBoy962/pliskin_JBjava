package com.pliskin.repository;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by aleksandrpliskin on 18.10.15.
 */
public interface PatientDataRepository {

    BigDecimal findByMedClinic(String name);

    BigDecimal findByMedClinicAndOffice(String name, String city, String street);


}
