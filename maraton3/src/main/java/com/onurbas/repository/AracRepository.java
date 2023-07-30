package com.onurbas.repository;

import com.onurbas.repository.entity.Arac;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class AracRepository implements ICrud<Arac> {
    Session session;
    Transaction transaction;
    @Override
    public Arac save(Arac arac) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı");
            transaction = session.beginTransaction();
            session.save(arac);
            transaction.commit();
            System.out.println("Kayıt başarılı");
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı");
            session.close();
        }
        return arac;
    }

    @Override
    public Arac update(Arac arac) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Arac> findAll() {
        return null;
    }

    @Override
    public Optional<Arac> findById(Long id) {
        return Optional.empty();
    }
}
