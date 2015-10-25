package com.pliskin.repository.impl;

import com.pliskin.repository.StuffDataRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by aleksandrpliskin on 23.10.15.
 */
@Transactional
@Repository
public class StuffDataRepositoryImpl implements StuffDataRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public BigDecimal findByMedClinic(String name) {
        Query query = entityManager.createNativeQuery("select AVG(stuff_data.salary) from med_clinic inner join office on med_clinic.id = office.med_clinic_id inner join people on office.id = people.office_id inner join stuff_data on stuff_data.id = people.id where med_clinic.name = ?");
        query.setParameter(1, name);
        return (BigDecimal) query.getSingleResult();
    }

    @Override
    public Integer findByMedClinicAndFio(String name, String fio) {
        Query query = entityManager.createNativeQuery("select stuff_data.salary from med_clinic inner join office on med_clinic.id = office.med_clinic_id inner join people on office.id = people.office_id inner join stuff_data on stuff_data.id = people.id where med_clinic.name = ? and people.fio = ?");
        query.setParameter(1, name);
        query.setParameter(2, fio);
        return (Integer) query.getSingleResult();
    }

    @Override
    public List<String> getByMedClinicFios(String name) {
        Query query = entityManager.createNativeQuery("SELECT people.fio from med_clinic INNER JOIN office on med_clinic.id = office.med_clinic_id INNER JOIN people on office.id = people.office_id WHERE med_clinic.name = ? AND people.type = 'WORKER'");
        query.setParameter(1, name);
        return query.getResultList();
    }

    @Override
    public Date getEmploymentDate(String name, String fio) {
        Query query = entityManager.createNativeQuery("select stuff_data.employment_date from med_clinic inner join office on med_clinic.id = office.med_clinic_id inner join people on office.id = people.office_id inner join stuff_data on stuff_data.id = people.id where med_clinic.name = ? and people.fio = ?");
        query.setParameter(1, name);
        query.setParameter(2, fio);
        return (Date) query.getSingleResult();
    }

    @Override
    public Date getDismissalDate(String name, String fio) {
        try {
            Query query = entityManager.createNativeQuery("select stuff_data.dismissal_date from med_clinic inner join office on med_clinic.id = office.med_clinic_id inner join people on office.id = people.office_id inner join stuff_data on stuff_data.id = people.id where med_clinic.name = ? and people.fio = ?");
            query.setParameter(1, name);
            query.setParameter(2, fio);
            return ((Date) query.getSingleResult());
        } catch (NullPointerException e) {
            return null;
        }
    }
}
