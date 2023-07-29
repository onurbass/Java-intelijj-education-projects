package com.mimaraslan.repository;

import com.mimaraslan.model.Arac;
import com.mimaraslan.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class EvRepository {

    public List<Arac> kiradaOlanEvler(){

        String hql="SELECT e FROM Arac e where e.durum='KIRADA'";
        Session session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Arac> typedQuery =session.createQuery(hql, Arac.class);
        return typedQuery.getResultList();
    }

    public Arac evOlustur(Arac arac) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(arac);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return arac;
    }

    public Arac evAraById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("EV DURUMU: " +session.get(Arac.class, id));
            return session.get(Arac.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Arac> kiradakiEvler() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Arac WHERE durum = 'KIRADA'", Arac.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Arac> musaitEvler() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Arac WHERE durum = 'MUSAIT'", Arac.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
