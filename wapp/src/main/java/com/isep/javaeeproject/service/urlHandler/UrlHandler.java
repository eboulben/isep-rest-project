package com.isep.javaeeproject.service.urlHandler;

public interface UrlHandler {

    public String getContentFrom(String urlParameters);

    public int putToRest(String tweets, String urlParameter);
}
