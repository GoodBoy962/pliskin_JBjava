package com.pliskin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by aleksandrpliskin on 17.10.15.
 */
@Entity
@Table(name = "patirnt_data")
public class PatientData {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "visit_date", nullable = false)
    private Date visitDate;

    @Column(name = "cost")
    private Integer cost;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "people_id", nullable = false)
    private People people;

    public void setId(Integer id) {
        this.id = id;
    }

    public PatientData() {

    }

    public PatientData(Date visitDate, Integer cost, People people, People peopleId) {
        this.visitDate = visitDate;
        this.cost = cost;
        this.people = people;
        this.people = people;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People peopleId) {
        this.people = peopleId;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }


}
