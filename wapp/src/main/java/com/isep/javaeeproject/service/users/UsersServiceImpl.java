package com.isep.javaeeproject.service.users;

import com.isep.javaeeproject.service.users.UsersService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Override
    public List<String> getUsers() {
        return getMockUsers();
    }

    public List<String> getMockUsers() {
        List<String> result = new ArrayList<>();
        result.add(0,"AltoLabs");
        result.add(1,"StartupVillage");
        result.add(2,"GlassFrance");
        return result;
    }
}
