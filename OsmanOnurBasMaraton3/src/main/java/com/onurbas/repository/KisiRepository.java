package com.onurbas.repository;

import com.onurbas.entity.Kisi;
import com.onurbas.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
	  return session.get(Kisi.class,id);
	} catch (Exception e) {
	  e.printStackTrace();
	  return null;
	}
  }

  public List<Kisi> getAllKisis() {
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	  return session.createQuery("from Kisi",Kisi.class).list();
	} catch (Exception e) {
	  e.printStackTrace();
	  return null;
	}
  }

  public void deleteKisiById(Long id) {
	Transaction transaction = null;
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	  transaction = session.beginTransaction();

	  Kisi kisi = session.get(Kisi.class,id);
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
	  System.out.println("KİŞİ DURUMU: " + session.get(Kisi.class,id));
	  return session.get(Kisi.class,id);
	} catch (Exception e) {
	  e.printStackTrace();
	  return null;
	}
  }

  @Override
  public void update(Kisi kisi) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	try {
	  transaction = session.beginTransaction();
	  session.update(kisi);
	  transaction.commit();
	} catch (Exception e) {
	  if (transaction != null) {
		transaction.rollback();
	  }
	  e.printStackTrace();
	} finally {
	  session.close();
	}
  }

  @Override
  public List<Kisi> findAll() {
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	  TypedQuery<Kisi> typedQuery = session.createQuery("FROM Kisi",Kisi.class);
	  typedQuery.getResultList().forEach(System.out::println);
	  return typedQuery.getResultList();
	} finally {
	  session.close();
	}
  }

  public boolean kisiKayitliMi(String saseNo) {
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	  String hql = "SELECT COUNT(k) FROM Kisi as k WHERE k.tcNo = :saseNo";
	  TypedQuery<Long> typedQuery = session.createQuery(hql,Long.class);
	  typedQuery.setParameter("saseNo",saseNo);
	  return typedQuery.getSingleResult() > 0;
	} catch (Exception ex) {
	  ex.printStackTrace();
	  return false;
	}
  }

}
