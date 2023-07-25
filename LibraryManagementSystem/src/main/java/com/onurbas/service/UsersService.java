package com.onurbas.service;

import com.onurbas.repository.UsersRepository;
import com.onurbas.repository.ICrud;
import com.onurbas.repository.entity.Users;

import java.util.List;
import java.util.Optional;

public class UsersService implements ICrud<Users> {
    private UsersRepository UsersRepository;

    public UsersService() {
        this.UsersRepository = new UsersRepository();
    }

    @Override
    public Users save(Users users) {
        return UsersRepository.save(users);
    }

    @Override
    public Users update(Users users) {
        return UsersRepository.update(users);
    }

    @Override
    public void deleteById(Long id) {
        UsersRepository.deleteById(id);
    }

    @Override
    public List<Users> findAll() {
        return UsersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return UsersRepository.findById(id);
    }
}
