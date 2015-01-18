package com.isep.javaeeproject.domain.repository.tweeter;

import com.isep.javaeeproject.domain.model.tweets.TweetsEntity;

import java.util.List;

public interface TweeterRepository {

    public void purge();

    public void insert(final List<TweetsEntity> tweets);

}
