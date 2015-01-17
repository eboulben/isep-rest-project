package com.isep.javaeeproject.domain.repository.tweets;

import com.isep.javaeeproject.domain.model.tweets.TweetsEntity;

import java.util.List;

public interface TweetsRepository {

    public List<TweetsEntity> getAllTweets();

    public TweetsEntity getTweet(final long id);

}
