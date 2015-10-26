package com.pliskin.repository.impl;

import com.pliskin.repository.PatientDataRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;

/**
 * Created by aleksandrpliskin on 23.10.15.
 */
@Transactional
@Repository
public class PatientDataRepositoryImpl implements PatientDataRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public BigDecimal findByMedClinic(String name) {
        Query query = entityManager.createNativeQuery("select AVG(patient_data.cost) from med_clinic inner join office on med_clinic.id = office.med_clinic_id inner join people on office.id = people.office_id inner join patient_data on patient_data.id = people.id where med_clinic.name = ?");
        query.setParameter(1, name);
        return (BigDecimal) query.getSingleResult();
    }

    @Override
    public BigDecimal findByMedClinicAndOffice(String name, String city, String street) {
        Query query = entityManager.createNativeQuery("select AVG(patient_data.cost) from med_clinic inner join office on med_clinic.id = office.med_clinic_id inner join people on office.id = people.office_id inner join patient_data on patient_data.id = people.id where med_clinic.name = ? and office.city = ? and office.street = ?");
        query.setParameter(1, name);
        query.setParameter(2, city);
        query.setParameter(3, street);
        return (BigDecimal) query.getSingleResult();
    }
}
