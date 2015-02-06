package com.isep.javaeeproject.service.tweeter;

import com.google.common.collect.Lists;
import com.isep.javaeeproject.dto.tweet.TweetDto;
import com.isep.javaeeproject.log.Log;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class TweeterApiConnectorServiceImpl implements TweeterApiConnectorService {

    private static final String TWITTER_CONSUMER_KEY = "7hWgkMsYODIzGT6lPnRiIeAjK";
    private static final String TWITTER_SECRET_KEY = "Dy3awOwow52xivlisbab1m52FpRnud0cCwOHDxM3CfG5NCsV8v";
    private static final String TWITTER_ACCESS_TOKEN = "2978155090-CMvEQjCXPo6uFiMhzBGWWiIEJt8eKoqThBV4e39";
    private static final String TWITTER_ACCESS_TOKEN_SECRET = "rq277m8NZEvNGFZ5MFfVvTJZf4OvG9ONccjE7SwNFhx4r";
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
