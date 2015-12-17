package com.pliskin.alex.model;

import com.pliskin.alex.model.enums.Sex;
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
    Sex sex;

    public UserInfo() {

    }

    public UserInfo(String name, String surname, String thirdName, String date, String sex) {
        this.name = name;
        this.surname = surname;
        this.thirdName = thirdName;
        this.date = date;
        this.sex = Sex.valueOf(sex);
    }

    public void reset() {
        name = null;
        surname = null;
        thirdName = null;
        date = null;
        sex = null;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex.toString();
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
        this.sex = Sex.valueOf(sex);
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
