package com.isep.javaeeproject.service.users;

import com.isep.javaeeproject.domain.model.users.Users;

import java.util.List;

public interface UsersService {

    public List<Users> getAllUsers();

    public Users getUser(final long id);

}
