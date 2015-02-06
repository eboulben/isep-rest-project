package com.isep.javaeeproject.service.tweets;

import com.isep.javaeeproject.dto.tweet.TweetDto;

import java.util.List;

public interface TweeterApiConnectorService {

    public List<TweetDto> getTweetsFromApiByAuthors(List<String> authors);

}
