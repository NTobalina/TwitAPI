package com.nick.twitapi.mapper;

import com.nick.twitapi.dto.TweetDTO;
import com.nick.twitapi.entity.Tweet;

import java.util.List;

public interface TweetMapper {
    Tweet toEntity(TweetDTO tweetDTO);

    List<Tweet> toEntity(List<TweetDTO> tweetDTOList);

    TweetDTO toDTO(Tweet tweet);

    List<TweetDTO> toDTO(List<Tweet> tweetList);
}
