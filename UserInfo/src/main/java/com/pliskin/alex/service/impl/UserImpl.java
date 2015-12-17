package com.pliskin.alex.service.impl;

import com.pliskin.alex.model.UserInfo;
import com.pliskin.alex.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aleksandrpliskin on 11.10.15.
 */
@Service
public class UserImpl implements User {
    @Autowired
    UserInfo userInfo;

    @Override
    public UserInfo getUserInfo() {
        return userInfo;
    }

    @Override
    public void addUserInfo(String name, String surname, String thirdName, String date, String sex) {
        userInfo.setName(name);
        userInfo.setSurname(surname);
        userInfo.setThirdName(thirdName);
        userInfo.setDate(date);
        userInfo.setSex(sex);
    }

    @Override
    public void reset() {
        userInfo.reset();
    }
}
