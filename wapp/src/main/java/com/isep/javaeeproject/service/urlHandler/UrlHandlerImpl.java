package com.isep.javaeeproject.service.urlHandler;

import com.isep.javaeeproject.log.Log;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class UrlHandlerImpl implements UrlHandler {

    @Log
    private Logger logger;
    private URL url;
    private HttpURLConnection httpURLConnection;
    @Value("${rest.protocol}")
    private String protocol;
    @Value("${rest.hostname}")
    private String hostname;
    @Value("${rest.port}")
    private int port;

    @Override
    public String getContentFrom(String urlParameters) {
        if (defineSuccessfullyUrlWith(urlParameters))
            return getContent();
        return "";
    }

    @Override
    public int putToRest(String tweets, String urlParameter) {
        if (defineSuccessfullyUrlWith(urlParameter))
            return updateRestWith(tweets);
        return 0;
    }

    private boolean defineSuccessfullyUrlWith(String urlParameters) {
        try {
            this.url = new URL(protocol, hostname, port, urlParameters);
            return true;
        } catch (MalformedURLException e) {
            logger.error("MalformedURLException in defineSuccessfullyUrlWith with parameters" + urlParameters);
            e.printStackTrace();
        }
        return false;
    }

    private String getContent() {
        String json = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            StringBuilder stringBuilder = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                stringBuilder.append(chars, 0, read);
            json = stringBuilder.toString();
        } catch (IOException e) {
            logger.error("IOException in getContent with URL " + url.toString());
            e.printStackTrace();
        }
        return json;
    }

    private int updateRestWith(String tweets) {
        if (!getHttpUrlConnection())
            return 0;
        createOutputStream(tweets);
        int responseCode = getResponseCode();
        httpURLConnection.disconnect();
        return (responseCode == 200) ? 1 : 0;
    }

    private int getResponseCode() {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            logger.error("IOException in getResponseCode with httpURLConnection as : "
                    + httpURLConnection.toString());
            e.printStackTrace();
            return 404;
        }
    }

    private void createOutputStream(String tweets) {
        try (OutputStreamWriter out = new OutputStreamWriter(
                httpURLConnection.getOutputStream())) {
            out.write(tweets);
        } catch (IOException e) {
            logger.error("IOException in getResponseCode with httpURLConnection while writing on it as : "
                    + httpURLConnection.toString());
            e.printStackTrace();
        }
    }

    private boolean getHttpUrlConnection() {
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("PUT");
            return true;
        } catch (IOException e) {
            logger.error("IOException in getHttpUrlConnection with url : " + url);
            e.printStackTrace();
        }
        return false;
    }
}
