package com.pliskin.service;

/**
 * Created by aleksandrpliskin on 16.12.15.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "Hello World";
    }

    @Override
    public String sayPhrase(String phrase) {
        return phrase;
    }
}
