package com.nick.twitapi.dto;

public class TweetDTO {

    private Long id;

    private String user;

    private String tweetText;

    private String location;

    private boolean validation;

    public Long getId() {
        return id;
    }

    public TweetDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUser() {
        return user;
    }

    public TweetDTO setUser(String user) {
        this.user = user;
        return this;
    }

    public String getTweetText() {
        return tweetText;
    }

    public TweetDTO setTweetText(String tweetText) {
        this.tweetText = tweetText;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public TweetDTO setLocation(String location) {
        this.location = location;
        return this;
    }

    public boolean isValidation() {
        return validation;
    }

    public TweetDTO setValidation(boolean validation) {
        this.validation = validation;
        return this;
    }
}
