package com.isep.javaeeproject.service.user;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.isep.javaeeproject.dto.tweet.TweetDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.isep.javaeeproject.web.mapping.RestMapping.*;

@Service
public class TweetsServiceImpl implements TweetsService {

    private Logger logger = LoggerFactory.getLogger(getClass());


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
            logger.info(inputStream.toString());
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private List<TweetDto> getMaps(String urlFileName) {
        List<TweetDto> tweets;

        String json = "";
        BufferedReader reader = null;
        try {
            URL url = new URL(PROTOCOL, HOSTNAME, PORT, urlFileName);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            json = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Date.class,
                (JsonDeserializer<Date>) (json2, typeOfT, context)
                        -> new Date(json2.getAsJsonPrimitive().getAsLong()));

        Gson gson = builder.create();

        Type type = new TypeToken<ArrayList<TweetDto>>() {
        }.getType();
        tweets = gson.fromJson(json, type);

        return tweets;
    }
}
