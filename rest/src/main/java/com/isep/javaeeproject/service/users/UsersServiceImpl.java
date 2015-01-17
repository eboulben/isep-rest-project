package com.isep.javaeeproject.service.users;

import com.isep.javaeeproject.domain.model.users.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Override
    public List<Users> getAllUsers() {
        List<Users> listOfUsers = new ArrayList<>();
        listOfUsers.add(new Users(12345l, "foo42"));
        listOfUsers.add(new Users(987l, "test23"));
        return listOfUsers;
    }

    @Override
    public Users getUsers(long id) {
        return new Users(id, "hurra !");
    }
}
