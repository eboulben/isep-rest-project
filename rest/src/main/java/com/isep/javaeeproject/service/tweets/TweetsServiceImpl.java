package com.isep.javaeeproject.service.tweets;

import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.isep.javaeeproject.domain.model.tweets.Tweets;
import com.isep.javaeeproject.domain.model.tweets.TweetsEntity;
import com.isep.javaeeproject.domain.repository.tweets.TweetsRepository;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TweetsServiceImpl implements TweetsService {

    @Autowired
    private TweetsRepository tweetsRepository;

    @Override
    public List<Tweets> getAllTweets() {
        List<TweetsEntity> allTweetsEntity = tweetsRepository.getAllTweets();
        return Lists.transform(allTweetsEntity, Tweets::new);
    }

    @Override
    public Tweets getTweet(final long id) {
        try {
            return new Tweets(tweetsRepository.getTweet(id));
        } catch (NoResultException e) {
            return new Tweets();
        }
    }

    @Override
    public List<Tweets> getTweetForUser(final String user) {
        List<TweetsEntity> tweetsEntitiesForUser = tweetsRepository.getTweetForUser(user);
        return Lists.transform(tweetsEntitiesForUser, Tweets::new);
    }

    @Override
    public void updateTweets(final String tweets) {
        List<Tweets> listTweet = getListTweets(tweets);
        if (!listTweet.isEmpty()) {
            tweetsRepository.purge();
            List<TweetsEntity> tweetsEntities = Lists.transform(listTweet,
                    TweetsEntity::new);
            tweetsRepository.insert(tweetsEntities);
        }
    }

    private List<Tweets> getListTweets(final String tweets) {
        Gson gson = getGsonConfigured();
        Type type = getTypeListOfTweets();
        return gson.fromJson(tweets, type);
    }

    private Type getTypeListOfTweets() {
        return new TypeToken<ArrayList<Tweets>>() {
        }.getType();
    }

    private Gson getGsonConfigured() {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("MMM dd, yyyy h:m:s a");
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(Date.class,
                (JsonDeserializer<Date>) (json, typeOfT, context)
                        -> fmt.parseDateTime(json.getAsString()).toDate());
        return gsonBuilder.create();
    }
}
