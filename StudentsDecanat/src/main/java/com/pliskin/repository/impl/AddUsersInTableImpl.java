package com.pliskin.repository.impl;

import com.pliskin.model.Scores;
import com.pliskin.model.Student;
import com.pliskin.repository.AddUsersInTable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by aleksandrpliskin on 15.10.15.
 */
@Repository
@Transactional
public class AddUsersInTableImpl implements AddUsersInTable {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addScores(Scores scores) {
        em.persist(scores);
    }
}
