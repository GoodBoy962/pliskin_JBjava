package com.pliskin.model;

/**
 * Created by aleksandrpliskin on 14.10.15.
 */

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "lastname")
    private String thirdName;

    @Column(name = "studgroup")
    private String group;

    public Student() {

    }

    public Student(String firstName, String surname, String lastName, String studGroup) {
        this.name = firstName;
        this.surname = surname;
        this.thirdName = lastName;
        this.group = studGroup;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getThirdName() {
        return thirdName;
    }

    public String getGroup() {
        return group;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }
}
