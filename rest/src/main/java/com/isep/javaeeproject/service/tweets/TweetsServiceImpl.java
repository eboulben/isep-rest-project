package com.isep.javaeeproject.service.tweets;

import com.isep.javaeeproject.domain.model.tweets.Tweets;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TweetsServiceImpl implements TweetsService {

    @Override
    public List<Tweets> getAllTweets() {
        List<Tweets> listOfTweets = new ArrayList<>();
        listOfTweets.add(new Tweets(12345l, 8765l, "@test", "hurra 2 for test!", new Date()));
        listOfTweets.add(new Tweets(3524l, 2527l, "@elVivaTest", "Viva el Useless", new Date(456789)));
        return listOfTweets;
    }

    @Override
    public Tweets getTweets(final long id) {
        return new Tweets(id, 8765l, "@test", "hurra for test!", new Date());
    }
}
