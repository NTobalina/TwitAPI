package com.nick.twitapi.repository;

import com.nick.twitapi.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    @Query(value = "select distinct t from Tweet t where t.validation is true and t.user = ?1")
    List<Tweet> findValidatedTweetsByUser(String user);
}
