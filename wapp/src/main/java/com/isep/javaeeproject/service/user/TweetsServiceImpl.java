package com.isep.javaeeproject.service.user;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.isep.javaeeproject.dto.tweet.TweetDto;
import com.isep.javaeeproject.utilities.UrlContentRetriever;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.isep.javaeeproject.web.mapping.RestMapping.*;

@Service
public class TweetsServiceImpl implements TweetsService {

    @Override
    public List<TweetDto> getTweets(String authorName) {
        return getMaps(REST_TWEETS_BY_AUTHOR + "/" + authorName);
    }

    @Override
    public List<TweetDto> getAllTweets() {
        return getMaps(REST_TWEETS);
    }

    @Override
    public int updateDatabase() {
        try {
            URL urlUpdate = new URL(PROTOCOL, HOSTNAME, PORT, REST_TWEETS_UPDATE);
            HttpURLConnection httpCon = (HttpURLConnection) urlUpdate.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            OutputStreamWriter out = new OutputStreamWriter(
                    httpCon.getOutputStream());
            out.write("Resource content");
            out.close();
            final InputStream inputStream = httpCon.getInputStream();
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private List<TweetDto> getMaps(String urlFileName) {
        String jsonRequested = getJsonFrom(urlFileName);
        Gson gson = getGsonBuilderWithDateTimestampHandling().create();
        return gson.fromJson(jsonRequested, getListOfTweetDtoType());
    }

    private String getJsonFrom(String urlFileName) {
        UrlContentRetriever retriever = new UrlContentRetriever();
        return retriever.getContentFrom(urlFileName);
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
