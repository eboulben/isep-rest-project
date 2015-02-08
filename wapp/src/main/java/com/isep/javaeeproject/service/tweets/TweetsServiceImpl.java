package com.isep.javaeeproject.service.tweets;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.isep.javaeeproject.dto.tweet.TweetDto;
import com.isep.javaeeproject.service.urlHandler.UrlHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TweetsServiceImpl implements TweetsService {

    @Value("${rest.tweets.authors}")
    private String tweetsByAuthors;
    @Value("${rest.tweets}")
    private String tweets;
    @Value("${rest.tweets.update}")
    private String tweetsUpdate;

    @Autowired
    private UrlHandler urlHandler;

    @Override
    public List<TweetDto> getTweets(final String authorName) {
        return getMaps(tweetsByAuthors + authorName);
    }

    @Override
    public List<TweetDto> getAllTweets() {
        return getMaps(tweets);
    }

    @Override
    public int updateDatabase(final List<TweetDto> tweets) {
        String json = new Gson().toJson(tweets);
        return urlHandler.putToRest(json, tweetsUpdate);
    }

    private List<TweetDto> getMaps(final String urlFileName) {
        String jsonRequested = getJsonFrom(urlFileName);
        Gson gson = getGsonBuilderWithDateTimestampHandling().create();
        return gson.fromJson(jsonRequested, getListOfTweetDtoType());
    }

    private String getJsonFrom(final String urlFileName) {
        return urlHandler.getContentFrom(urlFileName);
    }

    private GsonBuilder getGsonBuilderWithDateTimestampHandling() {
        return new GsonBuilder().registerTypeAdapter(Date.class,
                (JsonDeserializer<Date>) (json, typeOfT, context)
                        -> new Date(json.getAsJsonPrimitive().getAsLong()));
    }

    private Type getListOfTweetDtoType() {
        return new TypeToken<ArrayList<TweetDto>>() {
        }.getType();
    }
}
