package com.isep.javaeeproject.web.home;

import com.isep.javaeeproject.service.home.HomeService;
import com.isep.javaeeproject.web.mapping.Views;
import com.isep.javaeeproject.web.mapping.WebMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping(WebMapping.HOME)
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HomeService homeService;

    @RequestMapping
    public ModelAndView home() {
        logger.info("home Controller logger demonstration");
        ModelAndView mv = new ModelAndView(Views.HOME.getPath());
        ArrayList<String> users = homeService.getUsers();
        mv.addObject("users",users);
        mv.addObject("example", homeService.getExemple());
        return mv;
    }

    @ResponseBody
    @RequestMapping(WebMapping.UPDATE)
    public String response() {
        if(homeService.updateDatabase()) {
            return "1";
        } else {
            return "0";
        }
    }

}
