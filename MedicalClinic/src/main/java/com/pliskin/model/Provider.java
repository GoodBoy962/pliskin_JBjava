package com.pliskin.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aleksandrpliskin on 17.10.15.
 */
@Entity
@Table(name = "provider")
public class Provider {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @JoinColumn(name = "jur_info", nullable = false)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private JurInfo jurInfo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;


    public Provider() {

    }

    public Provider(String name, JurInfo jurInfo, Office office) {
        this.name = name;
        this.jurInfo = jurInfo;
        this.office = office;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public JurInfo getJurInfo() {
        return jurInfo;
    }

    public void setJurInfo(JurInfo jurInfo) {
        this.jurInfo = jurInfo;
    }
}
