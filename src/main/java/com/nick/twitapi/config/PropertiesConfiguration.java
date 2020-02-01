package com.nick.twitapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "tweet-properties")
    public TweetProperties tweetProperties() {
        return new TweetProperties();
    }
}
