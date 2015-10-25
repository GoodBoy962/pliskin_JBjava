package com.pliskin.repository.impl;

import com.pliskin.model.MedClinic;
import com.pliskin.repository.MedClinicRepository;
import com.pliskin.util.MathOperations;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by aleksandrpliskin on 23.10.15.
 */
@Transactional
@Repository
public class MedClinicRepositoryImpl implements MedClinicRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public String findTheBestMedClinic() {
        List<String> medClinicNames = this.getMedClinicNames();
        Map<String, Long> map = new HashMap<>();
        for (String name : medClinicNames) {
            Query query = entityManager.createNativeQuery("select SUM(patient_data.cost) from med_clinic inner join office on med_clinic.id = office.med_clinic_id inner join people on office.id = people.office_id inner join patient_data on patient_data.id = people.id where med_clinic.name = ?");
            query.setParameter(1, name);
            long sum = ((BigInteger) query.getSingleResult()).longValue();
            map.put(name, sum);
        }
        MathOperations<String> mathOperations = new MathOperations<>();
        return mathOperations.getMax(map);
    }

    @Override
    public List<String> getMedClinicNames() {
        Query query = entityManager.createNativeQuery("select name FROM med_clinic");
        return query.getResultList();
    }

    @Override
    public String findNameById(Integer id) {
        Query query = entityManager.createNativeQuery("select name from med_clinic where id = ?");
        query.setParameter(1, id);
        return (String) query.getSingleResult();
    }
}
