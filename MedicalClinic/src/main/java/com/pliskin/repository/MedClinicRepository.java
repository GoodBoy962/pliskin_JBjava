package com.pliskin.repository;

import java.util.List;

/**
 * Created by aleksandrpliskin on 18.10.15.
 */
public interface MedClinicRepository {
    String findTheBestMedClinic();

    List<String> getMedClinicNames();

    String findNameById(Integer id);
}
