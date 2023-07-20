package com.onurbas.controller;

import com.onurbas.repository.ICrud;
import com.onurbas.repository.entity.UserInfo;
import com.onurbas.service.UserInfoService;

import java.util.List;
import java.util.Optional;

public class UserInfoController implements ICrud<UserInfo> {
    UserInfoService userInfoService;


    public UserInfoController() {
        this.userInfoService=new UserInfoService();
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return userInfoService.save(userInfo);
    }

    @Override
    public UserInfo update(UserInfo userInfo) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoService.findAll();
    }

    @Override
    public Optional<UserInfo> findById(Long id) {
        return Optional.empty();
    }
}
