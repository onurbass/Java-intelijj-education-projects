package com.onurbas.repository;

import com.onurbas.repository.entity.Borrow;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class BorrowRepository implements ICrud<Borrow> {
    Session session;
    Transaction transaction;

    @Override
    public Borrow save(Borrow borrow) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı");
            transaction = session.beginTransaction();
            session.save(borrow);
            transaction.commit();
            System.out.println("Kayıt başarılı");
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı");
            session.close();
        }
        return borrow;
    }

    @Override
    public Borrow update(Borrow borrow) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Borrow> findAll() {
        return null;
    }

    @Override
    public Optional<Borrow> findById(Long id) {
        return Optional.empty();
    }
}
