package com.isep.javaeeproject.web.home;

import com.isep.javaeeproject.web.mapping.Views;
import com.isep.javaeeproject.web.mapping.WebMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(WebMapping.HOME)
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping
    public ModelAndView home() {
        logger.info("home Controller logger demonstration");
        return new ModelAndView(Views.HOME.getPath());
    }

}
