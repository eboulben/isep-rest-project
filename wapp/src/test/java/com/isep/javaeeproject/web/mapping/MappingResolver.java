package com.isep.javaeeproject.web.mapping;

public class MappingResolver {

    private static final String PATH_FROM_SRC = "/src/main/webapp/WEB-INF/views/";
    private static final String PATH_FROM_WEBINF = "/WEB-INF/views/";
    private static final String SUFFIX = ".jsp";

    public static String getFromSrc(String view) {
        return new StringBuilder().append(PATH_FROM_SRC).append(view).append(SUFFIX).toString();
    }

    public static String getFromWebinf(String view) {
        return new StringBuilder().append(PATH_FROM_WEBINF).append(view).append(SUFFIX).toString();
    }
}
