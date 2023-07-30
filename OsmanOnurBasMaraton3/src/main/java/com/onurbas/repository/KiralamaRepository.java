package com.onurbas.repository;

import com.onurbas.entity.Arac;
import com.onurbas.entity.Kiralama;
import com.onurbas.entity.Kisi;
import com.onurbas.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class KiralamaRepository implements ICrud<Kiralama> {
    private Session session;
    private Transaction transaction;



    @Override
    public Kiralama save(Kiralama kiralama) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(kiralama);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return kiralama;
    }

    @Override
    public Kiralama findById(Long id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Kiralama.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void kiradakiAraclar() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql="SELECT a from Arac as a where a.durum='KIRADA'";
            session.createQuery(hql, Kisi.class).list();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public List<Arac> kiralananAraclarByKisiId(Long id){
        String hql="SELECT k.arac FROM Kiralama k where k.kisi.id=:id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Arac> typedQuery =session.createQuery(hql, Arac.class);
        typedQuery.setParameter("id",id);
        return typedQuery.getResultList();
    }
}
