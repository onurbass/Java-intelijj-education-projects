package com.basonur;


import com.basonur.model.Customer;
import com.basonur.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class AppMain {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setFirstname("Burak");
        customer.setLastname("Delice");
        customer.setAddress("Ankara");
        customer.setCreationDate(new Date());
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(customer);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println("Hata : " + e);
        } finally {
            session.close();
        }
    }
}
