package org.example.repository;

import org.example.entity.Person;
import org.example.entity.Rental;
import org.example.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RentalRepository implements ICrud<Rental> {
    @Override
    public Rental add(Rental rental) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(rental);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return rental;
    }

    @Override
    public Rental search(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Rental.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
