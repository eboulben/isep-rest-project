package com.isep.javaeeproject.web.users;

import com.isep.javaeeproject.service.users.UsersService;
import com.isep.javaeeproject.web.mapping.Views;
import com.isep.javaeeproject.web.mapping.WebMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(WebMapping.USERS)
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        List<String> authors = usersService.getUsers();
        mv.setViewName(Views.USERS.getPath());
        mv.addObject("authors",authors);
        return mv;
    }
}
