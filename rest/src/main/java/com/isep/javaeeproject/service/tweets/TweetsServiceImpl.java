package com.isep.javaeeproject.service.tweets;

import com.google.common.collect.Lists;
import com.isep.javaeeproject.domain.model.tweets.Tweets;
import com.isep.javaeeproject.domain.model.tweets.TweetsEntity;
import com.isep.javaeeproject.domain.repository.tweets.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        TweetsEntity test = new TweetsEntity(id, 8765l, "@test", "hurra for test!", new Date());
        return new Tweets(test);
    }
}
