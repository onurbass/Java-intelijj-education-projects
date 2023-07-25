package com.onurbas.controller;

import com.onurbas.repository.entity.Author;
import com.onurbas.service.AuthorService;

public class AuthorController {

  private AuthorService authorService;

    public AuthorController() {
        this.authorService = new AuthorService();
    }

    public Author save(Author author){
      return   authorService.save(author);
    }

}
