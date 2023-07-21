package com.onurbas.repository;

import com.onurbas.repository.entity.Name;
import com.onurbas.repository.entity.User;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepository implements ICrud<User>{

    Session session;
    Transaction transaction;


    @Override
    public User save(User user) {
        try {
            session= HibernateUtility.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("kayıt başarısız");
            transaction.rollback();
        }
        return user;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> findAll() {
        //String hql ="select * from tbl_user";
        String hql = "select u from User as u";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery =session.createQuery(hql, User.class);
        List<User> userList = typedQuery.getResultList();

        return userList;
    }

    @Override
    public Optional<User> findById(Long id) {
        String hql=" select u from User as u where u.id=:myId";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery =session.createQuery(hql, User.class);
        typedQuery.setParameter("myId",id);
        User user1 = null;
        try {
            user1=typedQuery.getSingleResult();//tek sonuç getirir
        }catch (Exception e){
            System.out.println(e.toString());
        }
        System.out.println(user1);

        return Optional.ofNullable(user1);
    }
    public Optional<User> findByUsername(String username){
        String hql="select u from User as u where u.username=:myusername";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery =session.createQuery(hql, User.class);
        typedQuery.setParameter("myusername",username);
        User user1 = null;
        try {
            user1=typedQuery.getSingleResult();
        }catch (Exception e){
            System.out.println(e.toString());
        }

        System.out.println(user1);
        return Optional.ofNullable(user1);
    }

    public List<Name> findAllName(){
        String hql = "select u.name from User as u";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Name> typedQuery =session.createQuery(hql, Name.class);
        List<Name> nameList = typedQuery.getResultList();

        return nameList;
    }
    public List<String> findAllFirstName(){
        String hql = "select u.name.firstName from User as u";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<String> typedQuery =session.createQuery(hql, String.class);
        List<String> nameList = typedQuery.getResultList();
        //List<String> firstNameList = nameList.stream().map(x->x.getFirstName()).collect(Collectors.toList());

        return nameList;
    }

}
