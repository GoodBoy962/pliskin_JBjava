package com.pliskin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by aleksandrpliskin on 17.10.15.
 */
@Entity
@Table(name = "med_clinic")
public class MedClinic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Column(name = "licence_number", nullable = false)
    private Integer licenceNumber;

    public MedClinic() {

    }

    public MedClinic(String name, Date creationDate, Integer licenceNumber) {
        this.name = name;
        this.creationDate = creationDate;
        this.licenceNumber = licenceNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(Integer licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
