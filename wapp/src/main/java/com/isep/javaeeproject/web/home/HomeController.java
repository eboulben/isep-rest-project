package com.isep.javaeeproject.web.home;

import com.google.common.collect.Lists;
import com.isep.javaeeproject.dto.tweet.TweetDto;
import com.isep.javaeeproject.service.home.AuthorsService;
import com.isep.javaeeproject.service.user.TweetsService;
import com.isep.javaeeproject.web.mapping.Views;
import com.isep.javaeeproject.web.mapping.WebMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(WebMapping.HOME)
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthorsService authorsService;

    @Autowired
    private TweetsService tweetsService;

    @RequestMapping
    public ModelAndView home() {
        logger.info("home Controller logger demonstration");
        ModelAndView mv = new ModelAndView(Views.HOME.getPath());
        List<String> users = Lists.newArrayList(authorsService.getAuthors());
        List<TweetDto> tweets = tweetsService.getAllTweets();
        mv.addObject("users", users);
        mv.addObject("tweets", tweets);
        return mv;
    }

    @ResponseBody
    @RequestMapping(WebMapping.UPDATE)
    public String response() {
        if (authorsService.updateDatabase()) {
            return "1";
        } else {
            return "0";
        }
    }

    @RequestMapping("/getTweet/{author}")
    public ModelAndView responseTweets(@PathVariable("author") String author) {
        ModelAndView mv = new ModelAndView(Views.HOME.getPath());
        List<TweetDto> tweets = tweetsService.getTweets(author);
        mv.addObject("tweets", tweets);
        mv.addObject("users", authorsService.getAuthors());
        return mv;
    }

}
