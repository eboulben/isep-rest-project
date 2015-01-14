package com.isep.javaeeproject.web.home;

import com.isep.javaeeproject.service.home.HomeService;
import com.isep.javaeeproject.web.mapping.Views;
import com.isep.javaeeproject.web.mapping.WebMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        mv.addObject("update", "Update Database");
        mv.addObject("example", homeService.getExemple());
        return mv;
    }

    @RequestMapping(WebMapping.UPDATE)
    public ModelAndView homeAndUpdate() {
        logger.info("Updating database");
        ModelAndView mv = new ModelAndView(Views.HOME.getPath());
        mv.addObject("update", "Database Updated");
        mv.addObject("buttonState", "disabled");
        return mv;
    }

}
