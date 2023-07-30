package org.example.repository;

import org.example.entity.Enums.EVehicleStatus;
import org.example.entity.Rental;
import org.example.entity.Vehicle;
import org.example.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class VehicleRepository implements ICrud<Vehicle>, IVehicleReport{

    @Override
    public Vehicle add(Vehicle vehicle) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(vehicle);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public Vehicle search(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Vehicle.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Vehicle> availableOrRentedVehicles(EVehicleStatus eVehicleStatus) {
        Session session=null;
        try {
            String hql="Select v from Vehicle as v where v.status =:x";
            session =HibernateUtil.getSessionFactory().openSession();
            TypedQuery<Vehicle> typedQuery=session.createQuery(hql, Vehicle.class);
            typedQuery.setParameter("x",eVehicleStatus).getResultList().forEach(System.out::println);
            return typedQuery.setParameter("x",eVehicleStatus).getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Vehicle> rentedVehiclesByPersonId(Long id) {
        Session session=null;
        try {
            String hql="Select r.vehicle from Rental as r where r.person.id =:p";
            session =HibernateUtil.getSessionFactory().openSession();
            TypedQuery<Vehicle> typedQuery=session.createQuery(hql, Vehicle.class);
            typedQuery.setParameter("p",id).getResultList().forEach(System.out::println);
            return typedQuery.setParameter("p",id).getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}
