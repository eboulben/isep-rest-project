package com.isep.javaeeproject.web.mapping;

public final class WebMapping {

    public static final String DEFAULT = "/";

    public static final String HOME = "/home";
    public static final String REDIRECT_HOME = "redirect:/home";
    public static final String UPDATE = "/update";
    public static final String GET_TWEETS = "/getTweet/{author}";

    private WebMapping() {
    }

}
