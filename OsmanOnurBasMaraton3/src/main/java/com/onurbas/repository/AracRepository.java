package com.onurbas.repository;

import com.onurbas.entity.Arac;
import com.onurbas.entity.enums.EDurum;
import com.onurbas.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class AracRepository implements ICrud<Arac>, IAracRapor {
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
	  return session.get(Arac.class,id);
	} catch (Exception e) {
	  e.printStackTrace();
	  return null;
	} finally {
	  session.close();
	}
  }

  @Override
  public void update(Arac arac) {
	session = HibernateUtil.getSessionFactory().openSession();

	try {
	  transaction = session.beginTransaction();
	  session.update(arac);
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
  public List<Arac> findAll() {
	session = HibernateUtil.getSessionFactory().openSession();
	try {

	  TypedQuery<Arac> typedQuery = session.createQuery("FROM Arac ",Arac.class);
	  typedQuery.getResultList().forEach(System.out::println);
	  return typedQuery.getResultList();
	} finally {
	  session.close();
	}
  }

  //aracDurumSorgu ile kirada-müsait araçlar tek metotda sorgulanması
  @Override
  public List<Arac> aracDurumSorgu(EDurum durum) {
	try {
	  session = HibernateUtil.getSessionFactory().openSession();
	  String hql = "SELECT a FROM Arac as a WHERE a.durum = :durum";
	  TypedQuery<Arac> typedQuery = session.createQuery(hql,Arac.class);
	  typedQuery.setParameter("durum",durum);
	  return typedQuery.getResultList();
	} catch (Exception ex) {
	  ex.printStackTrace();
	  return null;
	} finally {
	  session.close();
	}
  }

  //müşteri id ile kiraladığı arabalara ulaşan hql sorgusu
  @Override
  public List<Arac> musterininKiraladigiArabalar(Long id) {

	try {
	  String hql = "Select k.arac from Kiralama as k where k.kisi.id =:p";
	  session = HibernateUtil.getSessionFactory().openSession();
	  TypedQuery<Arac> typedQuery = session.createQuery(hql,Arac.class);
	  typedQuery.setParameter("p",id);
	  typedQuery.getResultList().forEach(System.out::println);
	  return typedQuery.getResultList();
	} catch (HibernateException e) {
	  throw new RuntimeException(e);
	} finally {
	  session.close();
	}
  }
}