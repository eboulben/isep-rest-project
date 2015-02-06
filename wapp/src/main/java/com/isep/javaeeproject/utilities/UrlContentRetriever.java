package com.isep.javaeeproject.utilities;

import com.isep.javaeeproject.log.Log;
import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import static com.isep.javaeeproject.web.mapping.RestMapping.*;

public class UrlContentRetriever {

    @Log
    Logger logger;

    URL url;

    public String getContentFrom(String urlParameters) {
        if (defineSuccessfullyUrlWith(urlParameters))
            return getContentFrom(url);
        return "";
    }

    private boolean defineSuccessfullyUrlWith(String urlParameters) {
        try {
            this.url = new URL(PROTOCOL, HOSTNAME, PORT, urlParameters);
            return true;
        } catch (MalformedURLException e) {
            logger.error("MalformedURLException in defineSuccessfullyUrlWith with parameters" + urlParameters);
            e.printStackTrace();
        }
        return false;
    }

    private String getContentFrom(URL url) {
        String json = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            StringBuilder stringBuilder = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                stringBuilder.append(chars, 0, read);
            json = stringBuilder.toString();
        } catch (IOException e) {
            logger.error("IOException in getContentFrom with URL " + url.toString());
            e.printStackTrace();
        }
        return json;
    }

}
