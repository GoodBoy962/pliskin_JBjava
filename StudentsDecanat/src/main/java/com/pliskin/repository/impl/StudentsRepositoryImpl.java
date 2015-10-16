package com.pliskin.repository.impl;

import com.pliskin.repository.StudentsRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by aleksandrpliskin on 14.10.15.
 */
@Repository
@Transactional
public class StudentsRepositoryImpl implements StudentsRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer getId(String name, String surname, String thirdname) {
        Query query = entityManager.createNativeQuery("SELECT id FROM students WHERE firstname=? and surname=? and lastname=?");
        query.setParameter(1, name);
        query.setParameter(2, surname);
        query.setParameter(3, thirdname);
        return Integer.parseInt(query.getSingleResult().toString());
    }
}
