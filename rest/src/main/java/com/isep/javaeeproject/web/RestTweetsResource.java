package com.isep.javaeeproject.web;

import com.isep.javaeeproject.domain.model.tweets.Tweets;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Path("tweets")
public class RestTweetsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tweets> allTweets() {
        List<Tweets> listOfTweets = new ArrayList<>();
        listOfTweets.add(new Tweets(12345l, 8765l, "@test", "hurra for test!", new Date()));
        listOfTweets.add(new Tweets(3524l, 2527l, "@elVivaTest", "Viva el Useless", new Date(456789)));
        return listOfTweets;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tweets tweet(@PathParam("id") final Long id) {
        return new Tweets(id, 8765l, "@test", "hurra for test!", new Date());
    }

}
