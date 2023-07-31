package com.onurbas.repository;

import com.onurbas.entity.Kisi;
import com.onurbas.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;

public class KisiRepository implements ICrud<Kisi> {

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



}
