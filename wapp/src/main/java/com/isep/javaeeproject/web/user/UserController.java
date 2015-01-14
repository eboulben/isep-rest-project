package com.isep.javaeeproject.web.user;

import com.isep.javaeeproject.dto.user.TweetDto;
import com.isep.javaeeproject.service.user.UserService;
import com.isep.javaeeproject.service.user.UserServiceImpl;
import com.isep.javaeeproject.web.mapping.Views;
import com.isep.javaeeproject.web.mapping.WebMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(WebMapping.USER)

public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping
    public ModelAndView index() {
        return new ModelAndView(Views.USER.getPath());
    }

    @RequestMapping(WebMapping.USER_GLASSFRANCE)
    public ModelAndView glassFrance() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(Views.USER.getPath());
        mav.addObject("user","GlassFrance");
        return mav;
    }

    @RequestMapping(WebMapping.USER_ALTOLABS)
    public ModelAndView altoLabs() {
        List<TweetDto> testList = userService.getTweets("altoLabs");
        ModelAndView mav = new ModelAndView();
        mav.setViewName(Views.USER.getPath());
        mav.addObject("tweets",testList);
        mav.addObject("user","AltoLabs");
        return mav;
    }

    @RequestMapping(WebMapping.USER_STARTUPVILLAGE)
    public ModelAndView startupVillage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(Views.USER.getPath());
        mav.addObject("user","StartupVillage");
        return mav;
    }

}
