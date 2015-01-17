package com.isep.javaeeproject.service.tweets;

import com.google.common.collect.Lists;
import com.isep.javaeeproject.domain.model.tweets.Tweets;
import com.isep.javaeeproject.domain.model.tweets.TweetsEntity;
import com.isep.javaeeproject.domain.repository.tweets.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;

@Service
public class TweetsServiceImpl implements TweetsService {

    @Autowired
    private TweetsRepository tweetsRepository;

    @Override
    public List<Tweets> getAllTweets() {
        List<TweetsEntity> allTweetsEntity = tweetsRepository.getAllTweets();
        return Lists.transform(allTweetsEntity,
                Tweets::new);
    }

    @Override
    public Tweets getTweet(final long id) {
        try {
            return new Tweets(tweetsRepository.getTweet(id));
        } catch (NoResultException e) {
            return new Tweets();
        }
    }
 }
