package com.pliskin.model;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 17.10.15.
 */
@Entity
@Table(name = "office")
public class Office {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street")
    private String street;

    /*
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "med_clinic_id", nullable = false)
    private MedClinic medClinicId;
    */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "med_clinic_id", nullable = false)
    private MedClinic medClinic;


    public Office() {

    }


    public MedClinic getMedClinic() {
        return medClinic;
    }

    public void setMedClinic(MedClinic medClinic) {
        this.medClinic = medClinic;
    }

    public Office(String street, MedClinic medClinic, String city) {

        this.street = street;
        this.medClinic = medClinic;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
