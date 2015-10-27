package com.pliskin.repository.impl;

import com.pliskin.model.MedClinic;
import com.pliskin.model.Office;
import com.pliskin.repository.MedClinicRepository;
import com.pliskin.repository.OfficeRepository;
import com.pliskin.util.MathOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by aleksandrpliskin on 24.10.15.
 */
@Transactional
@Repository
public class OfficeRepositoryImpl implements OfficeRepository {

    @Autowired
    private MedClinicRepository medClinicRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Office> findByMedClinic(MedClinic medClinic) {
        Query query = entityManager.createNativeQuery("select * from office where med_clinic_id = med_clinic.id");
        return query.getResultList();
    }

    @Override
    public List<Integer> findAllId() {
        Query query = entityManager.createNativeQuery("select office.id from office");
        return query.getResultList();
    }

    @Override
    public String getMedClinicId(Integer id) {
        Query query = entityManager.createNativeQuery("SELECT med_clinic_id from office WHERE id = ?");
        query.setParameter(1, id);
        return medClinicRepository.findNameById((Integer) (query.getSingleResult()));
    }

    @Override
    public String getStreet(Integer id) {
        Query query = entityManager.createNativeQuery("SELECT street FROM office WHERE  id = ?");
        query.setParameter(1, id);
        return (String) query.getSingleResult();
    }

    @Override
    public String getCity(Integer id) {
        Query query = entityManager.createNativeQuery("SELECT city from office where id = ?");
        query.setParameter(1, id);
        return (String) query.getSingleResult();
    }

    @Override
    public List<String> getAllCities(String name) {
        Query query = entityManager.createNativeQuery("SELECT office.city FROM  office INNER JOIN  med_clinic on med_clinic.id = office.med_clinic_id WHERE med_clinic.name = ? ");
        query.setParameter(1, name);
        return query.getResultList();
    }

    @Override
    public List<String> getAllStreetInCityOfMedClinic(String name, String city) {
        Query query = entityManager.createNativeQuery("SELECT office.street FROM  office INNER JOIN  med_clinic on med_clinic.id = office.med_clinic_id WHERE med_clinic.name = ? and office.city = ?");
        query.setParameter(1, name);
        query.setParameter(2, city);
        return query.getResultList();
    }


    @Override
    public Integer getTheMostProfitableOffice() {
        List<Integer> offices = findAllId();
        Map<Integer, Long> map = new HashMap<>();
        for (Integer officeId : offices) {
            Query query = entityManager.createNativeQuery("select SUM(patient_data.cost) from  office  inner join people on office.id = people.office_id inner join patient_data on patient_data.id = people.id where office.id = ?");
            query.setParameter(1, officeId);
            map.put(officeId, ((BigInteger) query.getSingleResult()).longValue());
        }
        MathOperations<Integer> mathOperations = new MathOperations<>();
        return (offices.get(mathOperations.getMax(map)));
    }
}
