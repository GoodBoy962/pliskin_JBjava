package com.pliskin.alex.model;

import org.springframework.stereotype.Component;

/**
 * Created by aleksandrpliskin on 11.10.15.
 */
@Component
public class UserInfo {
    String name;
    String surname;
    String thirdName;
    String date;
    String sex;

    public UserInfo() {

    }

    public UserInfo(String name, String surname, String thirdName, String date, String sex) {
        this.name = name;
        this.surname = surname;
        this.thirdName = thirdName;
        this.date = date;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getThirdName() {
        return thirdName;
    }

    public String getSurname() {
        return surname;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
