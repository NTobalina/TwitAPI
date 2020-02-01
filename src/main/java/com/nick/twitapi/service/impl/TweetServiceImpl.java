package com.nick.twitapi.service.impl;

import com.nick.twitapi.config.TweetProperties;
import com.nick.twitapi.dto.TweetDTO;
import com.nick.twitapi.entity.Tweet;
import com.nick.twitapi.mapper.TweetMapper;
import com.nick.twitapi.repository.TweetRepository;
import com.nick.twitapi.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import twitter4j.*;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TweetServiceImpl implements TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private TweetMapper tweetMapper;

    @Autowired
    private TweetProperties tweetProperties;

    @Override
    @Transactional
    public List<TweetDTO> checkTimeline() {
        List<Tweet> tweetList = new ArrayList<>();

        List<Status> statusList = getCurrentStatusList();

        for (Status status : statusList) {
            if (status.getUser().getFollowersCount() >= tweetProperties.getFollowersMin() && tweetProperties.getAllowedLanguages().contains(status.getLang())) {
                Tweet tweet = new Tweet();
                tweet.setId(status.getId());
                tweet.setUser(status.getUser().getScreenName());
                tweet.setTweetText(status.getText());
                tweet.setLocation(status.getUser().getLocation());
                tweetList.add(tweet);
            }
        }

        return tweetMapper.toDTO(tweetRepository.saveAll(tweetList));
    }

    @Override
    @Transactional
    public TweetDTO validateTweet(Long id) throws Exception {
        Optional<Tweet> tweetById = tweetRepository.findById(id);

        if (!tweetById.isPresent()) {
            throw new Exception();
        }

        tweetById.get().setValidation(true);

        return tweetMapper.toDTO(tweetRepository.save(tweetById.get()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TweetDTO> getValidatedTweets(String user) {
        return tweetMapper.toDTO(tweetRepository.findValidatedTweetsByUser(user));
    }

    @Override
    public Map<String, Integer> getHashtagRanking() {

        List<Status> statusList = getCurrentStatusList();

        Map<String, Integer> hashtagForUses = new HashMap<>();

        for (Status status : statusList) {
            HashtagEntity[] hashtagEntities = status.getHashtagEntities();

            for (HashtagEntity hashtagEntity : hashtagEntities) {
                if (!hashtagForUses.containsKey(hashtagEntity.getText())) {
                    hashtagForUses.put(hashtagEntity.getText(), 1);
                } else {
                    hashtagForUses.put(hashtagEntity.getText(), hashtagForUses.get(hashtagEntity.getText()) + 1);
                }
            }

        }

        return sortByValue(hashtagForUses);
    }

    private List<Status> getCurrentStatusList() {
        List<Status> statusList = new ArrayList<>();

        try {

            // Gets Twitter instance with the credentials of the twitter4j.properties file
            Twitter twitter = new TwitterFactory().getInstance();
            User user = twitter.verifyCredentials();
            statusList = twitter.getHomeTimeline();
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }

        return statusList;
    }

    private Map<String, Integer> sortByValue(final Map<String, Integer> hashtagForUses) {
        return hashtagForUses.entrySet().stream()
            .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
            .limit(tweetProperties.getRankingSize())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
