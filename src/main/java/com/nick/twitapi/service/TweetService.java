package com.nick.twitapi.service;

import com.nick.twitapi.dto.TweetDTO;

import java.util.List;
import java.util.Map;

public interface TweetService {
    List<TweetDTO> checkTimeline();

    TweetDTO validateTweet(Long id) throws Exception;

    List<TweetDTO> getValidatedTweets(String user);

    Map<String, Integer> getHashtagRanking();
}
