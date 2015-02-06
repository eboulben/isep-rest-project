package com.isep.javaeeproject.service.home;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.isep.javaeeproject.utilities.UrlContentRetriever;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.isep.javaeeproject.web.mapping.RestMapping.REST_AUTHORS;

@Service
public class AuthorsServiceImpl implements AuthorsService {

    @Override
    public List<String> getAuthors() {
        String json = new UrlContentRetriever().getContentFrom(REST_AUTHORS);
        return new Gson().fromJson(json, new TypeToken<ArrayList<String>>() {
        }.getType());

    }

}
