package com.onurbas.service;

import com.onurbas.repository.UserInfoRepository;
import com.onurbas.repository.ICrud;
import com.onurbas.repository.entity.UserInfo;

import java.util.List;
import java.util.Optional;

public class UserInfoService implements ICrud<UserInfo> {

    private UserInfoRepository userInfoRepository;


    public UserInfoService() {
        this.userInfoRepository=new UserInfoRepository();
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    public UserInfo update(UserInfo userInfo) {
        return userInfoRepository.update(userInfo);
    }

    @Override
    public void deleteById(Long id) {
        userInfoRepository.deleteById(id);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    @Override
    public Optional<UserInfo> findById(Long id) {
        return userInfoRepository.findById(id);
    }
}
