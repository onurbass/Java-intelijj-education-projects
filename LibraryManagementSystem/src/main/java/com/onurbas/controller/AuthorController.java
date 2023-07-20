package com.onurbas.controller;

import com.onurbas.repository.ICrud;
import com.onurbas.repository.entity.Author;
import com.onurbas.service.AuthorService;

import java.util.List;
import java.util.Optional;

public class AuthorController implements ICrud<Author> {
    AuthorService authorService;


    public AuthorController() {
        this.authorService=new AuthorService();
    }

    @Override
    public Author save(Author author) {
        return authorService.save(author);
    }

    @Override
    public Author update(Author author) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.empty();
    }
}
