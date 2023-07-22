package com.onurbas.utility;

import com.onurbas.repository.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    private static final SessionFactory SESSION_FACTORY=createSessionFactory();

    private static SessionFactory createSessionFactory() {
        try {
            Configuration configuration= new Configuration();
            configuration.addAnnotatedClass(Users.class);
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(Borrow.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(UserInfo.class);
            configuration.addAnnotatedClass(Author.class);

            return configuration.configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }

}
