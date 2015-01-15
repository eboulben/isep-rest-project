package com.isep.javaeeproject.service.user;

import com.isep.javaeeproject.dto.user.TweetDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<TweetDto> getTweets(String authorName) {
        return getMock();
    }

    private List<TweetDto> getMock() {
        List<TweetDto> result = new ArrayList<>();
        result.add(0, new TweetDto("Un message","01/05/2012", "AltoLabs"));
        result.add(1, new TweetDto("Un message","01/05/2012", "AltoLabs"));
        result.add(2, new TweetDto("Un message","01/05/2012", "AltoLabs"));
        result.add(3, new TweetDto("Un message","01/05/2012", "AltoLabs"));
        result.add(4, new TweetDto("Un message","01/05/2012", "AltoLabs"));
        result.add(5, new TweetDto("Un message","01/05/2012", "AltoLabs"));
        result.add(6, new TweetDto("Un message","01/05/2012", "AltoLabs"));
        result.add(7, new TweetDto("Un message","01/05/2012", "AltoLabs"));
        result.add(8, new TweetDto("Un message","01/05/2012", "AltoLabs"));
        result.add(9, new TweetDto("Un message","01/05/2012", "AltoLabs"));
        return result;
    }
}
