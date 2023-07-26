package com.onurbas.repository;

import com.onurbas.repository.entity.Book;
import com.onurbas.repository.entity.Borrow;
import com.onurbas.repository.entity.Users;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BorrowRepository implements ICrud<Borrow> {
    Session session;
    Transaction transaction;
    @Override
    public Borrow save(Borrow borrow) {
        try {
            session= HibernateUtility.getSESSION_FACTORY().openSession();
            transaction=session.beginTransaction();
            System.out.println("Oturum acıldı...");
            session.save(borrow);
            transaction.commit();
            System.out.println("Kayıt başarılı...");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı...");
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

    public List<Borrow> getBorrowByUserId(Long id) {
        String hql = "select b from Borrow as b where b.users.id=:id";
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Borrow> typedQuery = session.createQuery(hql, Borrow.class);
        typedQuery.setParameter("id", id);

        List<Borrow>list = typedQuery.getResultList();
         session.close();

        return list;
    }

    public List<Users> findUserByBorrowedBook(Long id) {
        String hql = "select b.users from Borrow b where Borrow.book.id =:id";
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Users> typedQuery = session.createQuery(hql, Users.class);
        typedQuery.setParameter("id", id);
        List<Users>list = typedQuery.getResultList();
        session.close();

        return list;
    }

    //*****önemli
    public List<Users> findUserByBorrowedBook2(Long id) {
        String hql = "select b.users from Borrow b where b.book.id = :id";
        List<Users> list=null;
        try (Session session = HibernateUtility.getSESSION_FACTORY().openSession()) {
            TypedQuery<Users> typedQuery = session.createQuery(hql, Users.class);
            typedQuery.setParameter("id", id);
            list= typedQuery.getResultList();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }



}
