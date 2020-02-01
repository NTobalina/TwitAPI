package com.nick.twitapi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tweet")
public class Tweet {
    @Id
    private Long id;

    @NotNull
    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "tweet_text", nullable = false)
    private String tweetText;

    @Column(name = "location")
    private String location;

    @Column(name = "validation")
    private boolean validation;

    public Long getId() {
        return id;
    }

    public Tweet setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUser() {
        return user;
    }

    public Tweet setUser(String user) {
        this.user = user;
        return this;
    }

    public String getTweetText() {
        return tweetText;
    }

    public Tweet setTweetText(String tweetText) {
        this.tweetText = tweetText;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Tweet setLocation(String location) {
        this.location = location;
        return this;
    }

    public boolean isValidation() {
        return validation;
    }

    public Tweet setValidation(boolean validation) {
        this.validation = validation;
        return this;
    }
}
