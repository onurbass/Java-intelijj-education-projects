package com.onurbas.controller;

import com.onurbas.repository.entity.Users;
import com.onurbas.service.UsersService;

public class UserController {

  private   UsersService usersService;

    public UserController() {
        this.usersService = new UsersService();
    }

    public Users save(Users users){
      return   usersService.save(users);
    }

}
