package com.onurbas.repository;

import com.onurbas.model.Kiralama;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class KiralamaRepository implements ICrud<Kiralama>{
    Session session;
    Transaction transaction;
    @Override
    public Kiralama save(Kiralama kiralama) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı");
            transaction = session.beginTransaction();
            session.save(kiralama);
            transaction.commit();
            System.out.println("Kayıt başarılı");
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı");
            session.close();
        }
        return kiralama;
    }



    @Override
    public Kiralama update(Kiralama kiralama) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Kiralama> findAll() {
        return null;
    }

    @Override
    public Optional<Kiralama> findById(Long id) {
        return Optional.empty();
    }


}
