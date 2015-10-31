package com.pliskin.model;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Date date;

    private Time time;

    @ManyToOne
    @JoinColumn(name = "user_page", nullable = false)
    private User userPage;

    public Post(String text, Time time, Date date, User user, User userPage) {
        this.text = text;
        this.time = time;
        this.date = date;
        this.user = user;
        this.userPage = userPage;
    }

    public Post() {

    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUserPage() {
        return userPage;
    }

    public void setUserPage(User userPage) {
        this.userPage = userPage;
    }
}
