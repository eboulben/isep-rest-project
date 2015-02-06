package com.isep.javaeeproject.service.tweeter;

import com.isep.javaeeproject.dto.tweet.TweetDto;
import com.isep.javaeeproject.log.Log;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweeterApiConnectorServiceImpl implements TweeterApiConnectorService {

    @Log
    Logger logger;

    @Override
    public List<TweetDto> getTweetsFromApiByAuthors(List<String> authors) {

        return null;
    }
}
