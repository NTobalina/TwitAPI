package com.nick.twitapi.mapper.impl;

import com.nick.twitapi.dto.TweetDTO;
import com.nick.twitapi.entity.Tweet;
import com.nick.twitapi.mapper.TweetMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TweetMapperImpl implements TweetMapper {

    @Override
    public Tweet toEntity(TweetDTO tweetDTO) {
        Tweet tweet = new Tweet();
        tweet.setId(tweetDTO.getId());
        tweet.setUser(tweetDTO.getUser());
        tweet.setTweetText(tweetDTO.getTweetText());
        tweet.setLocation(tweetDTO.getLocation());
        tweet.setValidation(tweetDTO.isValidation());
        return tweet;
    }

    @Override
    public List<Tweet> toEntity(List<TweetDTO> tweetDTOList) {
        return tweetDTOList.stream().map(t -> toEntity(t)).collect(Collectors.toList());
    }

    @Override
    public TweetDTO toDTO(Tweet tweet) {
        TweetDTO tweetDTO = new TweetDTO();
        tweetDTO.setId(tweet.getId());
        tweetDTO.setUser(tweet.getUser());
        tweetDTO.setTweetText(tweet.getTweetText());
        tweetDTO.setLocation(tweet.getLocation());
        tweetDTO.setValidation(tweet.isValidation());
        return tweetDTO;
    }

    @Override
    public List<TweetDTO> toDTO(List<Tweet> tweetList) {
        return tweetList.stream().map(t -> toDTO(t)).collect(Collectors.toList());
    }
}
