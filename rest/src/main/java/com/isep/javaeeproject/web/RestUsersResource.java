package com.isep.javaeeproject.web;

import com.isep.javaeeproject.domain.model.users.Users;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("users")
public class RestUsersResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> allUsers() {
        List<Users> listOfUsers = new ArrayList<>();
        listOfUsers.add(new Users(12345l, "foo1"));
        listOfUsers.add(new Users(987l, "test23"));
        return listOfUsers;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Users user(@PathParam("id") Long id) {
        return new Users(id, "hurra !");
    }

}
