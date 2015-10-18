package com.pliskin.service.impl;

import com.pliskin.model.Scores;
import com.pliskin.model.Student;
import com.pliskin.model.enums.Subject;
import com.pliskin.repository.AddUsersInTable;
import com.pliskin.service.AddUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * Created by aleksandrpliskin on 15.10.15.
 */
@Service
public class AddUsersRepositoryImpl implements AddUsersRepository {


    @Autowired
    AddUsersInTable addUsersIntoTable;

    Subject[] subjects = Subject.values();

    @Transactional
    @Override
    public void add() {
        String name;
        String thirdname;
        String surname;
        String group;
        Subject subject;
        Integer score;
        Random rd = new Random();
        for (int i = 0; i < 300; i++) {
            name = "Alex" + i;
            surname = "Pliskin" + i;
            thirdname = "Markovich" + i;
            group = "11-40" + i;
            subject = subjects[rd.nextInt(6)];
            score = rd.nextInt(100);
            Student student = new Student(name, surname, thirdname, group);
            Scores scoreS = new Scores(subject, score, student);
            addUsersIntoTable.addScores(scoreS);
        }
    }
}
