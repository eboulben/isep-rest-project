package com.isep.javaeeproject.web.user;

import com.isep.javaeeproject.web.mapping.Views;
import com.isep.javaeeproject.web.mapping.WebMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(WebMapping.USER)
public class UserController {

    @RequestMapping
    public ModelAndView index() {
        return new ModelAndView(Views.USER.getPath());
    }

}
