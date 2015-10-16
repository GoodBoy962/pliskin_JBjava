package com.pliskin.model;

/**
 * Created by aleksandrpliskin on 14.10.15.
 */

import com.pliskin.model.enums.Subject;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Scores {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;


    @Column(name = "subject_type")
    @Enumerated(EnumType.STRING)
    private Subject subjectType;

    @Column(name = "score")
    private Integer score;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", nullable = false)
    private Student studentId;

    public Scores() {

    }

    public Scores(Subject subjectType, Integer score, Student studentId) {
        this.subjectType = subjectType;
        this.score = score;
        this.studentId = studentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subject getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Subject subjectType) {
        this.subjectType = subjectType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

}
