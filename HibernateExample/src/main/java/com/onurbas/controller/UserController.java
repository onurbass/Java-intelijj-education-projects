package com.onurbas.controller;

import com.onurbas.repository.ICrud;
import com.onurbas.repository.entity.Name;
import com.onurbas.repository.entity.User;
import com.onurbas.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserController implements ICrud<User> {
   private final UserService userService ;




    public UserController() {
        this.userService = new UserService();
    }

    public Optional<User> findByUsername(String username){
        return  userService.finByUsername(username);
    }

    @Override
    public User save(User user) {

        return userService.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userService.findById(id);
    }
    public List<Name> findAllName(){
        return  userService.findAllName();
    }
}
