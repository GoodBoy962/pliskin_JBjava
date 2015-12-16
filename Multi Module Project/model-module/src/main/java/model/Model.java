package main.java.model;

/**
 * Created by aleksandrpliskin on 16.12.15.
 */
public class Model {

    private String phrase;

    public Model(String phrase) {
        this.phrase = phrase;
    }

    public Model() {
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
