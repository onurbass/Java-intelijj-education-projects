package com.onurbas.repository;

import com.onurbas.entity.Arac;
import com.onurbas.entity.enums.EDurum;
import com.onurbas.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class AracRepository implements ICrud<Arac> {
    private Session session;
    private Transaction transaction;

    @Override
    public Arac save(Arac arac) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            System.out.println("Oturum açıldı");
            transaction = session.beginTransaction();
            session.save(arac);
            transaction.commit();
            System.out.println("Kayıt başarılı");
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            System.out.println("Oturum kapandı");
            session.close();
        }
        return arac;
    }

    @Override
    public Arac findById(Long id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Arac.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }


    public List<Arac> kiradakiAraclar() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "SELECT a FROM Arac as a WHERE a.durum = :durum";
            TypedQuery<Arac> typedQuery = session.createQuery(hql, Arac.class);
            typedQuery.setParameter("durum", EDurum.KIRADA);
            return typedQuery.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Arac> musaitAraclar() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "SELECT a FROM Arac as a WHERE a.durum = :durum";
            TypedQuery<Arac> typedQuery = session.createQuery(hql, Arac.class);
            typedQuery.setParameter("durum", EDurum.MUSAIT);
            return typedQuery.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean aracKayitliMi(String saseNo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(a) FROM Arac as a WHERE a.saseNo = :saseNo";
            TypedQuery<Long> typedQuery = session.createQuery(hql, Long.class);
            typedQuery.setParameter("saseNo", saseNo);
            return typedQuery.getSingleResult() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}