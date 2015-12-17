package com.pliskin.service;

import com.pliskin.model.HelloModel;

/**
 * Created by aleksandrpliskin on 16.12.15.
 */
public class HelloServiceImpl implements HelloService {

    HelloModel model = new HelloModel();

    @Override
    public String sayHello() {
        return "Hello World";
    }

    @Override
    public String sayPhrase() {
        return model.getPhrase();
    }

    @Override
    public void setPhrase(String phrase) {
        model.setPhrase(phrase);
    }
}
