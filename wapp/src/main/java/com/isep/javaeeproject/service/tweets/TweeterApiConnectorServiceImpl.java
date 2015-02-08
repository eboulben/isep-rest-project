package com.isep.javaeeproject.service.tweets;

import com.google.common.collect.Lists;
import com.isep.javaeeproject.dto.tweet.TweetDto;
import com.isep.javaeeproject.log.Log;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class TweeterApiConnectorServiceImpl implements TweeterApiConnectorService {

    @Value("${tweeter.consumer.key}")
    private String TWITTER_CONSUMER_KEY;
    @Value("${tweeter.secret.key}")
    private String TWITTER_SECRET_KEY;
    @Value("${tweeter.access.token}")
    private String TWITTER_ACCESS_TOKEN;
    @Value("${tweeter.access.token.secret}")
    private String TWITTER_ACCESS_TOKEN_SECRET;
    @Log
    Logger logger;

    @Override
    public List<TweetDto> getTweetsFromApiByAuthors(List<String> authors) {
        List<Status> listTweets = getTweetsFromApi(authors);
        return transformToListOfTweetDto(listTweets);
    }

    private List<Status> getTweetsFromApi(List<String> authors) {
        List<Status> endResult = Lists.newArrayList();
        Twitter twitter = getTwitterObjectConfigured();
        List<Query> queryList = createQueries(authors);
        return getStatusesForQueries(endResult, twitter, queryList);
    }

    private List<Status> getStatusesForQueries(List<Status> endResult, Twitter twitter, List<Query> queryList) {
        for (Query query : queryList)
            try {
                endResult.addAll(twitter.search(query).getTweets());
            } catch (TwitterException te) {
                logger.warn("Failed to search tweets for query : " + query.toString());
                te.printStackTrace();
            }
        return endResult;
    }

    private List<Query> createQueries(List<String> authors) {
        List<Query> queryList = new ArrayList<>();
        for (int i = 0; i < authors.size(); i++) {
            Query query = new Query("from:" + authors.get(i));
            query.count(10);
            queryList.add(i, query);
        }
        return queryList;
    }

    private Twitter getTwitterObjectConfigured() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        logger.info(TWITTER_CONSUMER_KEY);
        logger.info(TWITTER_SECRET_KEY);
        logger.info(TWITTER_ACCESS_TOKEN);
        logger.info(TWITTER_ACCESS_TOKEN_SECRET);
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
                .setOAuthConsumerSecret(TWITTER_SECRET_KEY)
                .setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
        return new TwitterFactory(cb.build()).getInstance();
    }

    private List<TweetDto> transformToListOfTweetDto(List<Status> listTweets) {
        return Lists.transform(listTweets,
                input -> new TweetDto(input.getId(), input.getUser().getScreenName(),
                        input.getText(), input.getCreatedAt()));
    }
}
