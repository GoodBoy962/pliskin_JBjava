package com.pliskin.repository;

import com.pliskin.model.MedClinic;
import com.pliskin.model.Office;
import com.pliskin.model.StuffData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
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
