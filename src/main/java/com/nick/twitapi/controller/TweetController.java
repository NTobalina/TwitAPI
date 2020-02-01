package com.nick.twitapi.controller;

import com.nick.twitapi.dto.TweetDTO;
import com.nick.twitapi.service.TweetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Nicolás Tobalina
 */
@RestController
@RequestMapping("/api")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    private final Logger log = LoggerFactory.getLogger(TweetController.class);

    /**
     * Check the latest tweets of the timeline and saves the new ones on the database.
     *
     * @return the list of tweets
     * @throws Exception if an error occurs
     */
    @GetMapping("/check-timeline")
    ResponseEntity<List<TweetDTO>> checkTimeline() throws Exception {
        log.info("GET request to check the latest tweets of the timeline");
        return new ResponseEntity<>(tweetService.checkTimeline(), HttpStatus.OK);
    }

    /**
     * Validates the request tweet with its id.
     *
     * @param id the id of the tweet to validate
     * @return the validated tweet
     * @throws Exception if an error occurs
     */
    @PatchMapping("/validate-tweet")
    ResponseEntity<TweetDTO> validateTweet(@RequestParam(value = "id") Long id) throws Exception {
        log.info("PATCH request to validate the tweet with id = " + id);
        return new ResponseEntity<>(tweetService.validateTweet(id), HttpStatus.OK);
    }

    /**
     * Gets the validated tweets of a specified user.
     *
     * @param user the @name of the user to search
     * @return the list of validated tweets
     * @throws Exception if an error occurs
     */
    @GetMapping("/validated-tweets")
    ResponseEntity<List<TweetDTO>> getValidatedTweets(@RequestParam(value = "user") String user) throws Exception {
        log.info("GET request to get the validated tweets of the user = " + user);
        return new ResponseEntity<>(tweetService.getValidatedTweets(user), HttpStatus.OK);
    }

    /**
     * Gets the ranking of the most used hashtags on the current timelime.
     *
     * @return the ranking with the hahhtags and the number of uses
     * @throws Exception if an error occurs
     */
    @GetMapping("/hashtag-ranking")
    ResponseEntity<Map<String, Integer>> getHashtagRanking() throws Exception {
        log.info("GET request to get the ranking of the most used hashtags");
        return new ResponseEntity<>(tweetService.getHashtagRanking(), HttpStatus.OK);
    }

}
