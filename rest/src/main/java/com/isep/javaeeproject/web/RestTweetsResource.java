package com.isep.javaeeproject.web;

import com.isep.javaeeproject.domain.model.tweets.Tweets;
import com.isep.javaeeproject.service.tweets.TweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("tweets")
public class RestTweetsResource {

    @Autowired
    private TweetsService tweetsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tweets> allTweets() {
        return tweetsService.getAllTweets();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tweets tweet(@PathParam("id") final Long id) {
        return tweetsService.getTweets(id);
    }

}
