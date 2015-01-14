package com.isep.javaeeproject.service.home;

import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Override
    public String getExemple() {
        return "this is an exemple";
    }
}
