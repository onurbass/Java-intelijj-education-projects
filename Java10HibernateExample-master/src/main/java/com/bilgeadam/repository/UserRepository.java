package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.User;
import com.bilgeadam.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserRepository implements ICrud<User>{
    Session session;
    Transaction transaction;

    @Override
    public User save(User user) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı...");
            transaction= session.beginTransaction();
           session.save(user);
            transaction.commit();
            System.out.println("Kayıt başarılı....");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            System.out.println("Kayıt başarısız!!!!!");
        }finally {
            System.out.println("oturum kapanıyor...");
            session.close();
        }
        return  user;
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
      //  String sql=" select * from tbl_user";
        String hql=" select u from User as u";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery= session.createQuery(hql, User.class);
        List<User> userList=typedQuery.getResultList();
        return userList;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }
}
