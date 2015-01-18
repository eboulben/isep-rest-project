package com.isep.javaeeproject.service.tweeter;

import com.google.common.collect.Lists;
import com.isep.javaeeproject.domain.model.tweets.TweetsEntity;
import com.isep.javaeeproject.domain.repository.tweeter.TweeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class TweeterServiceImpl implements TweeterService {

    private static final String TWITTER_CONSUMER_KEY = "7hWgkMsYODIzGT6lPnRiIeAjK";
    private static final String TWITTER_SECRET_KEY = "Dy3awOwow52xivlisbab1m52FpRnud0cCwOHDxM3CfG5NCsV8v";
    private static final String TWITTER_ACCESS_TOKEN = "2978155090-CMvEQjCXPo6uFiMhzBGWWiIEJt8eKoqThBV4e39";
    private static final String TWITTER_ACCESS_TOKEN_SECRET = "rq277m8NZEvNGFZ5MFfVvTJZf4OvG9ONccjE7SwNFhx4r";

    private org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    @Autowired
    private TweeterRepository tweeterRepository;

    @Override
    public void refreshDataWithTwitterApi() {
        List<Status> listTweets = getTweetsFromApi();
        List<TweetsEntity> tweetsEntities = Lists.transform(listTweets,
                input -> new TweetsEntity(input.getId(), input.getUser().getScreenName(),
                        input.getText(), input.getCreatedAt()));
        if (!tweetsEntities.isEmpty()) tweeterRepository.purge();
        tweeterRepository.insert(tweetsEntities);
    }

    private List<Status> getTweetsFromApi() {

        List<Status> endResult = Lists.newArrayList();

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
                .setOAuthConsumerSecret(TWITTER_SECRET_KEY)
                .setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        try {
            List<Query> queryList = new ArrayList<>();
            queryList.add(0, new Query("from:altoLabs"));
            queryList.add(1, new Query("from:glassfrance"));
            queryList.add(2, new Query("from:startupvillage"));
            for (Query query : queryList) {
                query.setCount(10);
                QueryResult queryResult = twitter.search(query);
                endResult.addAll(queryResult.getTweets());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            logger.warn("Failed to search tweets: " + te.getMessage());
        }

        return endResult;
    }
}
