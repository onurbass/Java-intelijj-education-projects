package com.onurbas.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    private static final SessionFactory SESSION_FACTORY=createSessionFactory();

    private static SessionFactory createSessionFactory() {
        try {
            Configuration configuration= new Configuration();
            SessionFactory sessionFactory=configuration.configure("hibernate.cfg.xml").buildSessionFactory();

            return sessionFactory;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }

}
