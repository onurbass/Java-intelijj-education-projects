package com.onurbas.controller;

import com.onurbas.repository.entity.UserInformation;
import com.onurbas.service.UserInformationService;

import java.util.List;

public class UserInformationController {

    private UserInformationService userInformationService;

    public UserInformationController() {
        this.userInformationService = new UserInformationService();
    }

    public UserInformation save(UserInformation userInformation){
        return userInformationService.save(userInformation);
    }


    public List<UserInformation> findAll(){
        return userInformationService.findAll();
    }

}
