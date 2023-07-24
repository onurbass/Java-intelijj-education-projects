package com.onurbas.repository;

import com.onurbas.repository.entity.Author;
import com.onurbas.repository.entity.Book;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class AuthorRepository implements ICrud<Author> {
    Session session;
    Transaction transaction;

    @Override
    public Author save(Author author) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı");
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
            System.out.println("Kayıt başarılı");
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı");
            session.close();
        }
        return  author;
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

    public List<Book> startsWithA(){
        String hql="select a.firstName,a.book from Author as a group by a.firstName having a.firstName like 'A%'";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Book> typedQuery = session.createQuery(hql,Book.class);



        return typedQuery.getResultList();
    }
}
