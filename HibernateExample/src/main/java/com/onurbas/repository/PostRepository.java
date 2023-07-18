package com.onurbas.repository;

import com.onurbas.repository.entity.Post;
import com.onurbas.repository.entity.User;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PostRepository implements ICrud<Post> {
    Session session;
    Transaction transaction;


    @Override
    public Post save(Post post) {
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(post);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            transaction.rollback();
        }
        return post;
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.empty();
    }
}
