package com.isep.javaeeproject.service.user;

import com.isep.javaeeproject.dto.tweet.TweetDto;

import java.util.List;

public interface UserService {
    public List<TweetDto> getTweets(String authorName);

    public List<TweetDto> getAllTweets();
}
