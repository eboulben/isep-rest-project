package com.isep.javaeeproject.service.user;

import com.google.common.collect.Lists;
import com.isep.javaeeproject.dto.tweet.TweetDto;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.isep.javaeeproject.web.mapping.RestMapping.*;

@Service
public class TweetsServiceImpl implements TweetsService {

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
