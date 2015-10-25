package com.pliskin.model;

import com.pliskin.model.enums.PeopleType;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 17.10.15.
 */
@Entity
@Table(name = "people")
public class People {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "fio", nullable = false)
    private String fio;

    @Column(name = "pasport_series", nullable = false)
    private String pasportSeries;

    @Column(name = "pasport_number", nullable = false)
    private String pasportNumber;

    @Column(name = "pasport_issues", nullable = false)
    private String pasportIssues;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PeopleType type;

    @JoinColumn(name = "office_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Office officeId;

    public People() {

    }

    public People(String fio, String pasportSeries, String pasportNumber, String pasportIssues, PeopleType type, Office officeId) {
        this.fio = fio;
        this.pasportSeries = pasportSeries;
        this.pasportNumber = pasportNumber;
        this.pasportIssues = pasportIssues;
        this.type = type;
        this.officeId = officeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Office getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Office officeId) {
        this.officeId = officeId;
    }

    public PeopleType getType() {
        return type;
    }

    public void setType(PeopleType type) {
        this.type = type;
    }

    public String getPasportIssues() {
        return pasportIssues;
    }

    public void setPasportIssues(String pasportIssues) {
        this.pasportIssues = pasportIssues;
    }

    public String getPasportNumber() {
        return pasportNumber;
    }

    public void setPasportNumber(String pasportNumber) {
        this.pasportNumber = pasportNumber;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPasportSeries() {
        return pasportSeries;
    }

    public void setPasportSeries(String pasportSeries) {
        this.pasportSeries = pasportSeries;
    }
}
