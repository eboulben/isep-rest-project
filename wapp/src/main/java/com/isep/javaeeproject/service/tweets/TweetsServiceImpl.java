package com.isep.javaeeproject.service.tweets;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.isep.javaeeproject.dto.tweet.TweetDto;
import com.isep.javaeeproject.log.Log;
import com.isep.javaeeproject.utilities.UrlHandler;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.isep.javaeeproject.web.mapping.RestMapping.*;

@Service
public class TweetsServiceImpl implements TweetsService {

    @Override
    public List<TweetDto> getTweets(final String authorName) {
        return getMaps(REST_TWEETS_BY_AUTHOR + "/" + authorName);
    }

    @Override
    public List<TweetDto> getAllTweets() {
        return getMaps(REST_TWEETS);
    }

    @Override
    public int updateDatabase(final List<TweetDto> tweets) {
        String json = new Gson().toJson(tweets);
        return new UrlHandler().putToRest(json, REST_TWEETS_UPDATE);
    }

    private List<TweetDto> getMaps(final String urlFileName) {
        String jsonRequested = getJsonFrom(urlFileName);
        Gson gson = getGsonBuilderWithDateTimestampHandling().create();
        return gson.fromJson(jsonRequested, getListOfTweetDtoType());
    }

    private String getJsonFrom(final String urlFileName) {
        return new UrlHandler().getContentFrom(urlFileName);
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
