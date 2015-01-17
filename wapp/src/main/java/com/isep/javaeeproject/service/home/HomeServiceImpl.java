package com.isep.javaeeproject.service.home;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HomeServiceImpl implements HomeService {

    @Override
    public String getExemple() {
        return "this is an exemple";
    }

    @Override
    public boolean updateDatabase() {
        return true;
    }

    @Override
    public ArrayList<String> getUsers() {
        return getMockUsers();
    }

    private ArrayList<String> getMockUsers() {
        ArrayList<String> result = new ArrayList<>();
        result.add(0, "AltoLabs");
        result.add(1, "GlassFrance");
        result.add(2, "StartupVillage");
        return result;
    }

}
