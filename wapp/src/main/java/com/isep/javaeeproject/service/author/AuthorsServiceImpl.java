package com.isep.javaeeproject.service.author;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.isep.javaeeproject.service.urlHandler.UrlHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorsServiceImpl implements AuthorsService {

    @Value("${rest.authors}")
    private String authors;

    @Autowired
    private UrlHandler urlHandler;

    @Override
    public List<String> getAuthors() {
        String json = urlHandler.getContentFrom(authors);
        return new Gson().fromJson(json, new TypeToken<ArrayList<String>>() {
        }.getType());
    }

}
