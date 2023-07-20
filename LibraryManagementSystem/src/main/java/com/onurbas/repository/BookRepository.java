package com.onurbas.repository;

import com.onurbas.repository.entity.Book;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class BookRepository implements ICrud<Book> {
    Session session;
    Transaction transaction;

    @Override
    public Book save(Book book) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı");
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            System.out.println("Kayıt başarılı");
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı");
            session.close();
        }
        return  book;
    }

    @Override
    public Book update(Book book) {
        return null;
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
}
