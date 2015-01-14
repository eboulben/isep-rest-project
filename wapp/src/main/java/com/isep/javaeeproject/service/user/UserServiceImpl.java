package com.isep.javaeeproject.service.user;

import com.isep.javaeeproject.dto.user.TweetDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getExemple() {
        return "test";
    }

    @Override
    public List<TweetDto> getTweets() {
        return null;
    }
}
