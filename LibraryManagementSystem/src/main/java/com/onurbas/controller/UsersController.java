package com.onurbas.controller;

import com.onurbas.repository.ICrud;
import com.onurbas.repository.entity.Users;
import com.onurbas.service.UsersService;

import java.util.List;
import java.util.Optional;

public class UsersController implements ICrud<Users> {
    UsersService usersService;


    public UsersController() {
        this.usersService=new UsersService();
    }

    @Override
    public Users save(Users adress) {
        return null;
    }

    @Override
    public Users update(Users adress) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Optional<Users> findById(Long id) {
        return Optional.empty();
    }
}
