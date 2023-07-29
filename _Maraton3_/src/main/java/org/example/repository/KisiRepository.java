package org.example.repository;

import org.example.entity.Kisi;
import org.example.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class KisiRepository implements ICrud<Kisi> {

    public void saveOrdUpdateKisi(Kisi kisi) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(kisi);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Kisi getKisiById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Kisi.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Kisi> getAllKisis() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Kisi", Kisi.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteKisiById(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Kisi kisi = session.get(Kisi.class, id);
            if (kisi != null) {
                session.delete(id);
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Kisi save(Kisi kisi) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(kisi);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return kisi;
    }

    @Override
    public Kisi findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("KİŞİ DURUMU: " +session.get(Kisi.class, id));
            return session.get(Kisi.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean kisiKayitliMi(String saseNo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(k) FROM Kisi as k WHERE k.tcNo = :saseNo";
            TypedQuery<Long> typedQuery = session.createQuery(hql, Long.class);
            typedQuery.setParameter("saseNo", saseNo);
            return typedQuery.getSingleResult() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }






}
