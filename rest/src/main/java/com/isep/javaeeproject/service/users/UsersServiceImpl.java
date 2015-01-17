package com.isep.javaeeproject.service.users;

import com.isep.javaeeproject.domain.repository.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<String> getAllUsers() {
        return usersRepository.getAllUsers();
    }

}
