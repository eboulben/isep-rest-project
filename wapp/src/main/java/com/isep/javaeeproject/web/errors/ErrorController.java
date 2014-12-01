package com.isep.javaeeproject.web.errors;

import com.isep.javaeeproject.web.mapping.ErrorMapping;
import com.isep.javaeeproject.web.mapping.Views;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(ErrorMapping.URL)
public class ErrorController {

    @RequestMapping(ErrorMapping.WEBXML_404)
    public ModelAndView error404Resolver() {
        return new ModelAndView(ErrorMapping.REDIRECT_PAGE_404);
    }

    @RequestMapping(ErrorMapping.PAGE_404)
    public ModelAndView page404() {
        return new ModelAndView(Views.ERROR_404.getPath());
    }

}
