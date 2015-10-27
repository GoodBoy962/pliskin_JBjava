package com.pliskin.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by aleksandrpliskin on 17.10.15.
 */
@Entity
@Table(name = "jur_info")
public class JurInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String sries;

    @Column
    private String number;

    @Column(name = "unic_number_uuid", nullable = false)
    private UUID unicNumberUUID;

    public JurInfo(String sries, String number, UUID unicNumberUUID) {
        this.sries = sries;
        this.number = number;
        this.unicNumberUUID = unicNumberUUID;
    }

    public UUID getUnicNumberUUID() {
        return unicNumberUUID;
    }

    public void setUnicNumberUUID(UUID unicNumberUUID) {
        this.unicNumberUUID = unicNumberUUID;
    }

    public JurInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSries() {
        return sries;
    }

    public void setSries(String sries) {
        this.sries = sries;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
