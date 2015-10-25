package com.pliskin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by aleksandrpliskin on 17.10.15.
 */
@Entity
@Table(name = "stuff_data")
public class StuffData {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "employment_date", nullable = false)
    private Date employmentDate;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "expected_time", nullable = false)
    private Integer expectedTime;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "people_id", nullable = false)
    private People peopleId;

    public StuffData() {

    }

    public StuffData(Date employmentDate, Date creationDate, Integer expectedTime, Integer salary, People peopleId) {
        this.creationDate = creationDate;
        this.employmentDate = employmentDate;
        this.expectedTime = expectedTime;
        this.salary = salary;
        this.peopleId = peopleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Integer expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public People getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(People peopleId) {
        this.peopleId = peopleId;
    }
}
