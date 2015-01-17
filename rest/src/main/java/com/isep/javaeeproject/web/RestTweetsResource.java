package com.isep.javaeeproject.web;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("tweets")
public class RestTweetsResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "this is a test";
    }

}
