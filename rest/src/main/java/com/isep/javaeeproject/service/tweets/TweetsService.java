package com.isep.javaeeproject.service.tweets;

import com.isep.javaeeproject.domain.model.tweets.Tweets;

import java.util.List;

public interface TweetsService {

    public List<Tweets> getAllTweets();

    public Tweets getTweets(final long id);

}
