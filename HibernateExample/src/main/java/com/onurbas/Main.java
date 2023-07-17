package com.onurbas;


import com.onurbas.repository.entity.User;
import com.onurbas.repository.enums.EGender;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {


        User user = User.builder()
                .name("Onur")
                .username("onurbass")
                .password("123456")
                .gender(EGender.MEN)
                .age(26)
                .build();

        Session session = null;
        Transaction transaction = null;

        try {
             session = HibernateUtility.getSessionFactory().openSession();
             transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();

        }
    }
}