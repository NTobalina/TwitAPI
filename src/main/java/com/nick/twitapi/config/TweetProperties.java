package com.nick.twitapi.config;

import java.util.List;

public class TweetProperties {
    private int followersMin;
    private List<String> allowedLanguages;
    private int rankingSize;

    public int getFollowersMin() {
        return followersMin;
    }

    public TweetProperties setFollowersMin(int followersMin) {
        this.followersMin = followersMin;
        return this;
    }

    public List<String> getAllowedLanguages() {
        return allowedLanguages;
    }

    public TweetProperties setAllowedLanguages(List<String> allowedLanguages) {
        this.allowedLanguages = allowedLanguages;
        return this;
    }

    public int getRankingSize() {
        return rankingSize;
    }

    public TweetProperties setRankingSize(int rankingSize) {
        this.rankingSize = rankingSize;
        return this;
    }
}
