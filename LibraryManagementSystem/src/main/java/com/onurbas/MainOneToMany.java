package com.onurbas;

import com.onurbas.controller.AuthorController;
import com.onurbas.controller.BookController;
import com.onurbas.repository.entity.Author;
import com.onurbas.repository.entity.Book;
import com.onurbas.repository.enums.EBookType;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;

import javax.persistence.TypedQuery;

public class MainOneToMany {


    public static void main(String[] args) {

        AuthorController authorController=new AuthorController();
        BookController bookController=new BookController();

        Author author= Author.builder().firstName("Kemal").lastName("Tahir").build();

        Book book1=Book.builder().title("Hür Şehrin İnsanları").bookType(EBookType.HISTORY).author(author).build();
        Book book2=Book.builder().title("Esir Şehrin İnsanları").bookType(EBookType.HISTORY).author(author).build();
        Book book3=Book.builder().title("Yorgun Savaşçı").bookType(EBookType.HISTORY).author(author).build();
//        author.setBooks(List.of(book1,book2,book3));
//        authorController.save(author);
        bookController.save(book1);
        bookController.save(book2);
        bookController.save(book3);

        Session session= HibernateUtility.getSESSION_FACTORY().openSession();
        String hql="select a from Author as a where a.id=1";
        TypedQuery<Author> typedQuery=session.createQuery(hql, Author.class);
        Author newAuthor= typedQuery.getSingleResult();
        session.close();;
        System.out.println(newAuthor.getFirstName());
        System.out.println(newAuthor.getBooks());
    }
}
