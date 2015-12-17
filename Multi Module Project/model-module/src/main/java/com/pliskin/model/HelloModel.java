package com.pliskin.model;

/**
 * Created by aleksandrpliskin on 16.12.15.
 */
public class HelloModel {

    private String phrase;

    public HelloModel(String phrase) {
        this.phrase = phrase;
    }

    public HelloModel() {
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
