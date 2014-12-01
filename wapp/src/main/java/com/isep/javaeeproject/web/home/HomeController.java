package com.isep.javaeeproject.web.home;

import com.isep.javaeeproject.web.mapping.Views;
import com.isep.javaeeproject.web.mapping.WebMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(WebMapping.HOME)
public class HomeController {

    @RequestMapping
    public ModelAndView home() {
        return new ModelAndView(Views.HOME.getPath());
    }

}
