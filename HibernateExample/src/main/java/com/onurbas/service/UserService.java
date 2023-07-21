package com.onurbas.service;

import com.onurbas.repository.ICrud;
import com.onurbas.repository.UserRepository;
import com.onurbas.repository.entity.Name;
import com.onurbas.repository.entity.User;

import java.util.List;
import java.util.Optional;

public class UserService implements ICrud<User> {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository =new UserRepository();
    }


    @Override
    public User save(User user) {

        return userRepository.save(user);
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
        return userRepository.findById(id);
    }

    public Optional<User> finByUsername(String username) {
        Optional<User> user=userRepository.findByUsername(username);
        if (user.isEmpty()){
            System.out.println("Bulunamadı");
        }
        return user;
    }

    public List<Name> findAllName() {
        return userRepository.findAllName();
    }
}
