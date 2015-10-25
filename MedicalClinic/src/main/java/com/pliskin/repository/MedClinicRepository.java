package com.pliskin.repository;

import com.pliskin.model.MedClinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aleksandrpliskin on 18.10.15.
 */
public interface MedClinicRepository {
    String findTheBestMedClinic();

    List<String> getMedClinicNames();

    String findNameById(Integer id);
}
