package com.onurbas.repository;

import com.onurbas.repository.entity.User;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserRepository implements ICrud<User>{

    Session session;
    Transaction transaction;


    @Override
    public User save(User user) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            transaction.rollback();
        }
        return user;
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
        return Optional.empty();
    }
}
