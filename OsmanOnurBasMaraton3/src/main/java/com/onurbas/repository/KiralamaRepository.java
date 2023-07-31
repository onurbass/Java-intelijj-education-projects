package com.onurbas.repository;

import com.onurbas.entity.Arac;
import com.onurbas.entity.Kiralama;
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
	  return session.get(Kiralama.class,id);
	} catch (Exception e) {
	  e.printStackTrace();
	  return null;
	} finally {
	  session.close();
	}
  }

  @Override
  public void update(Kiralama kiralama) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	try {
	  transaction = session.beginTransaction();
	  session.update(kiralama);
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
  public List<Kiralama> findAll() {
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {

	  TypedQuery<Kiralama> typedQuery = session.createQuery("FROM Kiralama ",Kiralama.class);
	  typedQuery.getResultList().forEach(System.out::println);
	  return typedQuery.getResultList();
	} finally {
	  session.close();
	}
  }


}
