package com.isep.javaeeproject.web;

import com.isep.javaeeproject.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("authors")
public class RestUsersResource {

    @Autowired
    UsersService usersService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> allUsers() {
        return usersService.getAllUsers();
    }

}
