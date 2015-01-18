package com.isep.javaeeproject.service.home;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

import static com.isep.javaeeproject.web.mapping.RestMapping.*;

@Service
public class AuthorsServiceImpl implements AuthorsService {

    @Override
    public String[] getAuthors() {
        ObjectMapper mapper = new ObjectMapper();
        String[] users;
        try {
            users = mapper.readValue(new URL(PROTOCOL, HOSTNAME, PORT, REST_AUTHORS), (new String[0]).getClass());
        } catch (IOException e) {
            e.printStackTrace();
            users = new String[0];
        }
        return users;
    }

}
