package com.isep.javaeeproject.service.tweets;

import com.isep.javaeeproject.dto.tweet.TweetDto;

import java.util.List;

public interface TweetsService {
    public List<TweetDto> getTweets(String authorName);

    public List<TweetDto> getAllTweets();

    public int updateDatabase(List<TweetDto> tweets);
}
