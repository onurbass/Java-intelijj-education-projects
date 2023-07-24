package com.onurbas.controller;

import com.onurbas.repository.ICrud;
import com.onurbas.repository.entity.Book;
import com.onurbas.repository.enums.EBookTypes;
import com.onurbas.service.BookService;

import java.util.List;
import java.util.Optional;

public class BookController implements ICrud<Book> {
    BookService bookService;


    public BookController() {
        this.bookService=new BookService();
    }

    @Override
    public Book save(Book book) {
        return bookService.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookService.update(book);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }
    public List<Book> getBookByType(EBookTypes type) {
        return bookService.getBookByType(type);
    }
}
