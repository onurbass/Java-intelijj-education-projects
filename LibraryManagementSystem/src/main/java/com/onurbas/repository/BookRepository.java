package com.onurbas.repository;
import com.onurbas.repository.entity.Author;
import com.onurbas.repository.entity.Book;
import com.onurbas.repository.enums.EBookType;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class BookRepository implements ICrud<Book> {
    Session session;
    Transaction transaction;
    @Override
    public Book save(Book book) {
        try {
            session= HibernateUtility.getSESSION_FACTORY().openSession();
            transaction=session.beginTransaction();
            System.out.println("Oturum acıldı...");
            session.save(book);
            transaction.commit();
            System.out.println("Kayıt başarılı...");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı...");
            session.close();
        }
        return book;
    }

    @Override
    public Book update(Book book) {
        try {
            session=HibernateUtility.getSESSION_FACTORY().openSession();
            transaction= session.beginTransaction();
            System.out.println("Oturum acıldı...");
            session.update(book);
            transaction.commit();
            System.out.println("Guncelleme başarılı...");
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            System.out.println("Oturum kapandı...");
            session.close();
        }
        return book;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    public List<Book> getBooksByType(EBookType type){
        String hql="select b from Book as b where b.bookType=:x";
        session=HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery=session.createQuery(hql, Book.class);
        typedQuery.setParameter("x",type);
        return typedQuery.getResultList();
    }
    public List<Book> getBooksByType(){
        String hql="select b from Book as b where b.bookType='NOVEL'";
        session=HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery=session.createQuery(hql, Book.class);
        return typedQuery.getResultList();
    }

    public List<Book> getBooksByTitle(String title) {
        String hql = "select b from Book as b where b.title=:title";
        session = HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);
        typedQuery.setParameter("title", title);
      //  session.close();

        return typedQuery.getResultList();
    }

    public List<Book> getBooksByTypeWithCriteria(EBookType type){
        EntityManager entityManager=HibernateUtility.getSESSION_FACTORY().createEntityManager();
        CriteriaBuilder criteriaBuilder =entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery=criteriaBuilder.createQuery(Book.class);
        Root<Book> root=criteriaQuery.from(Book.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("bookType"),type));
        List<Book> list = entityManager.createQuery(criteriaQuery).getResultList();
        session.close();
        return list;
    }
    public List<Book> getBooksByTypeWithCriteria(String title){
        EntityManager entityManager=HibernateUtility.getSESSION_FACTORY().createEntityManager();
        CriteriaBuilder criteriaBuilder =entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery=criteriaBuilder.createQuery(Book.class);
        Root<Book> root=criteriaQuery.from(Book.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("title"),title));
        List<Book> list =entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return list;
    }
    public List<Book> getBooksByTypeNamedQuery(EBookType type){
        session=HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery=session.createNamedQuery("findByBookType", Book.class);
        typedQuery.setParameter("myType",type);
        return typedQuery.getResultList();
    }
    public List<Book> getBooksWithAuthorNameStartWith(String value){
        String hql="select b from Book as b  where b.author.firstName like '"+value+"%'";
        session=HibernateUtility.getSESSION_FACTORY().openSession();
        TypedQuery<Book> typedQuery=session.createQuery(hql, Book.class);
        return typedQuery.getResultList();
    }
}
