package com.onurbas;

import com.onurbas.controller.AuthorController;
import com.onurbas.controller.BookController;
import com.onurbas.repository.entity.Author;
import com.onurbas.repository.entity.Book;
import com.onurbas.repository.enums.EBookTypes;

import java.util.List;
import java.util.Set;

public class MainOneToMany {
    public static void main(String[] args) {
        AuthorController authorController = new AuthorController();
        BookController bookController = new BookController();
        Author author = Author.builder().firstName("onur").lastName("baş")
                .build();
        Book book = Book.builder().title("asffsa").bookType(EBookTypes.HISTORY).author(author).build();
        Book book1 = Book.builder().title("abcd").bookType(EBookTypes.HISTORY).author(author).build();
        Book book2 = Book.builder().title("sadsad").bookType(EBookTypes.HISTORY).author(author).build();

        author.setBook(List.of(book,book1,book2));

        authorController.save(author);
    }


}
