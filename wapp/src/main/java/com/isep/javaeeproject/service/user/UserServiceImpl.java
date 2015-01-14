package com.isep.javaeeproject.service.user;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getExemple() {
        return "test";
    }
}
