package com.isep.javaeeproject.web;

import com.isep.javaeeproject.domain.model.users.Users;
import com.isep.javaeeproject.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("users")
public class RestUsersResource {

    @Autowired
    UsersService usersService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> allUsers() {
        return usersService.getAllUsers();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Users user(@PathParam("id") long id) {
        return usersService.getUsers(id);
    }

}
