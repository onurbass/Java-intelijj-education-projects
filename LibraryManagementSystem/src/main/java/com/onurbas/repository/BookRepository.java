package com.onurbas.repository;

import com.onurbas.repository.entity.Book;
import com.onurbas.repository.enums.EBookTypes;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class BookRepository implements ICrud<Book> {
    Session session;
    Transaction transaction;

    @Override
    public Book save(Book book) {
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı");
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            System.out.println("Kayıt başarılı");
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            transaction.rollback();
        } finally {
            System.out.println("Oturum kapandı");
            session.close();
        }
        return book;
    }

    @Override
    public Book update(Book book) {
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı");
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
            System.out.println("Kayıt başarılı");
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            transaction.rollback();
        } finally {
            System.out.println("Oturum kapandı");
            session.close();
        }
        return book;
    }

@Override
public void deleteById(Long id){

        }

@Override
public List<Book> findAll(){
        return null;
        }

@Override
public Optional<Book> findById(Long id){
        return Optional.empty();
        }


    public List<Book> getBookByType(EBookTypes type){
        String hql="select b from Book as b where b.bookType=:x";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Book> bookTypedQuery = session.createQuery(hql,Book.class);
        bookTypedQuery.setParameter("x",type);


        return bookTypedQuery.getResultList();
    }

        }


