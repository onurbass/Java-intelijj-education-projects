package com.onurbas.repository;

import com.onurbas.model.Ev;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class EvRepository implements ICrud<Ev> {
    Session session;
    Transaction transaction;
    @Override
    public Ev save(Ev ev) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı");
            transaction = session.beginTransaction();
            session.save(ev);
            transaction.commit();
            System.out.println("Kayıt başarılı");
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı");
            session.close();
        }
        return ev;
    }

    @Override
    public Ev update(Ev ev) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Ev> findAll() {
        return null;
    }

    @Override
    public Optional<Ev> findById(Long id) {
        return Optional.empty();
    }
}
