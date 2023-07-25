package com.onurbas.repository;

import com.onurbas.model.Kisi;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class KisiRepository implements ICrud<Kisi>{
    Session session;
    Transaction transaction;

    @Override
    public Kisi save(Kisi kisi) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı");
            transaction = session.beginTransaction();
            session.save(kisi);
            transaction.commit();
            System.out.println("Kayıt başarılı");
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı");
            session.close();
        }
        return kisi;
    }

    @Override
    public Kisi update(Kisi kisi) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Kisi> findAll() {
        return null;
    }

    @Override
    public Optional<Kisi> findById(Long id) {
        return Optional.empty();
    }
}
