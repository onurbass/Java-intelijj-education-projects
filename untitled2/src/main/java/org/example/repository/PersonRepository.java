package org.example.repository;

import org.example.entity.Person;
import org.example.entity.Vehicle;
import org.example.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonRepository implements ICrud<Person> {
    @Override
    public Person add(Person person) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person search(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Person.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
