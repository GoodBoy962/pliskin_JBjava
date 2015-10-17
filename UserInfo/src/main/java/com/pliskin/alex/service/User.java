package com.pliskin.alex.service;

import com.pliskin.alex.model.UserInfo;

/**
 * Created by aleksandrpliskin on 11.10.15.
 */
public interface User {
    UserInfo getUserInfo();

    void addUserInfo(String name, String surname, String thirdName, String date, String sex);
}
