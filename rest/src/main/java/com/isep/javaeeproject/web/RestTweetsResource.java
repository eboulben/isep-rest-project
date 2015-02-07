package com.isep.javaeeproject.web;

import com.isep.javaeeproject.domain.model.tweets.Tweets;
import com.isep.javaeeproject.service.tweets.TweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Tweets tweet(@PathParam("id") final long id) {
        return tweetsService.getTweet(id);
    }

    @GET
    @Path("/author/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tweets> allTweetsForUser(@PathParam("user") final String user) {
        return tweetsService.getTweetForUser(user);
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    @Path("/update")
    public Response update(final String tweets) {
        tweetsService.updateTweets(tweets);
        return Response.status(Response.Status.OK)
                .entity("The database has been updated")
                .header("Location", "http://localhost:8080/rest/tweets/update").build();
    }

}
