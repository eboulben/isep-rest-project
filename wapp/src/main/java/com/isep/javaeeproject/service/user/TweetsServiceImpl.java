package com.isep.javaeeproject.service.user;

import com.google.common.collect.Lists;
import com.isep.javaeeproject.dto.tweet.TweetDto;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.isep.javaeeproject.web.mapping.RestMapping.*;

@Service
public class TweetsServiceImpl implements TweetsService {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public List<TweetDto> getTweets(String authorName) {
        List<Map<String, String>> tweets = getMaps(new StringBuilder().append(REST_TWEETS_BY_AUTHOR)
                .append("/").append(authorName).toString());
        return getTweetDtos(tweets);
    }

    @Override
    public List<TweetDto> getAllTweets() {
        List<Map<String, String>> tweets = getMaps(REST_TWEETS);
        return getTweetDtos(tweets);
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

    private List<Map<String, String>> getMaps(String urlFileName) {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> tweets;

        try {
            tweets = mapper.readValue(new URL(PROTOCOL, HOSTNAME, PORT, urlFileName),
                    (new ArrayList<Map<String, String>>()).getClass());
        } catch (IOException e) {
            e.printStackTrace();
            tweets = Lists.newArrayList();
        }

        return tweets;
    }

    private List<TweetDto> getTweetDtos(List<Map<String, String>> tweets) {
        List<TweetDto> response = Lists.newArrayList();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");

        response.addAll(tweets.stream().map(map -> new TweetDto(map.getOrDefault("message", ""),
                new DateTime(map.getOrDefault("date", "0")).toString(formatter),
                map.getOrDefault("author", ""))).collect(Collectors.toList()));

        return response;
    }
}
