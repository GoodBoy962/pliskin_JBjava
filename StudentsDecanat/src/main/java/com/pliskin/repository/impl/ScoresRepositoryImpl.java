package com.pliskin.repository.impl;

import com.pliskin.repository.ScoresRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

/**
 * Created by aleksandrpliskin on 14.10.15.
 */
@Repository
@Transactional
public class ScoresRepositoryImpl implements ScoresRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer getTotal(Integer id) {
        Query query = entityManager.createNativeQuery("SELECT SUM(score) FROM scores WHERE student_id=?");
        query.setParameter(1, id);
        try {
            return Integer.parseInt(query.getSingleResult().toString());
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public BigDecimal getAverage(Integer id) {
        Query query = entityManager.createNativeQuery("SELECT AVG(score) FROM scores WHERE student_id=?");
        query.setParameter(1, id);
        BigDecimal bigDecimal;
        try {
            bigDecimal = (BigDecimal) query.getSingleResult();
        } catch (NoResultException e) {
            bigDecimal = null;
        }
        return bigDecimal;
    }

    @Override
    public Integer getCurrentSubject(Integer id, String subject) {
        Query query = entityManager.createNativeQuery("SELECT score FROM scores WHERE student_id=? AND subject_type=?");
        query.setParameter(1, id);
        query.setParameter(2, subject);
        try {
            return Integer.parseInt(query.getSingleResult().toString());
        } catch (NoResultException e) {
            return null;
        }
    }
}
