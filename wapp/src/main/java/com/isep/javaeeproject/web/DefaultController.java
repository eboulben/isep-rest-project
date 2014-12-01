package com.isep.javaeeproject.web;

import com.isep.javaeeproject.web.mapping.WebMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(WebMapping.DEFAULT)
public class DefaultController {

    @RequestMapping
    public ModelAndView defaultHandler() {
        return new ModelAndView(WebMapping.REDIRECT_HOME);
    }
}
