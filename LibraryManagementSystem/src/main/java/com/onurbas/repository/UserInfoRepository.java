package com.onurbas.repository;

import com.onurbas.repository.entity.UserInfo;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserInfoRepository implements ICrud<UserInfo> {
    Session session;
    Transaction transaction;
    @Override
    public UserInfo save(UserInfo userInfo) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı");
            transaction = session.beginTransaction();
            session.save(userInfo);
            transaction.commit();
            System.out.println("Kayıt başarılı");
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı");
            session.close();
        }
        return userInfo;
    }

    @Override
    public UserInfo update(UserInfo userInfo) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<UserInfo> findAll() {
        return null;
    }

    @Override
    public Optional<UserInfo> findById(Long id) {
        return Optional.empty();
    }
}
