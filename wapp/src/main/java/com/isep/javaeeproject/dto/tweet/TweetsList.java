package com.isep.javaeeproject.dto.tweet;

import java.util.List;

public class TweetsList {

    private List<Tweets> allTweets;

    public List<Tweets> getAllTweets() {
        return allTweets;
    }

    public void setAllTweets(List<Tweets> allTweets) {
        this.allTweets = allTweets;
    }

    @Override
    public String toString() {
        return "TweetsList{" +
                "allTweets=" + allTweets +
                '}';
    }
}
