package com.pliskin.repository.impl;

import com.pliskin.repository.OperationSupplierRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by aleksandrpliskin on 25.10.15.
 */
@Repository
public class OperationSupplierRepositoryImpl implements OperationSupplierRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<String> whenWasSend(String providerName, String name, String city, String street) {
        Query query = entityManager.createNativeQuery("select begin_date from med_clinic INNER JOIN office on med_clinic.id = office.med_clinic_id INNER JOIN provider on provider.office_id = office.id INNER JOIN operation_supplier ON operation_supplier.provider_id = provider.id and operation_supplier.office_id = office.id where med_clinic.name = ? and office.city = ? and office.street = ? and provider.name = ?");
        query.setParameter(1, name);
        query.setParameter(2, city);
        query.setParameter(3, street);
        query.setParameter(4, providerName);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }


}
