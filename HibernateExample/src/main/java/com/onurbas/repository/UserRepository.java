package com.onurbas.repository;

import com.onurbas.repository.entity.Name;
import com.onurbas.repository.entity.User;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NamedQuery;
import javax.persistence.Query;
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
        //String sql ="select * from tbl_user";
        String hql = "select u from User as u ";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery =session.createQuery(hql, User.class);
        List<User> userList = typedQuery.getResultList();

        return userList;
    }

    @Override
    public Optional<User> findById(Long id) {
        String sql = " select * from tbl_user where id="+id;
        String hql=" select u from User as u where u.id=:myId";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery =session.createQuery(hql, User.class);
        typedQuery.setParameter("myId",id);
        User user1 = null;
        try {
            user1=  typedQuery.getSingleResult();//tek sonuç getirir
        }catch (Exception e){
            System.out.println(e.toString());
        }
        System.out.println(user1);

        return Optional.ofNullable(user1);
    }
    public Optional<User> findByUsername(String username){
        // String sql = "select * from tbl_user where tbl_user.username = "+username;
        String hql="select u from User as u where u.username=:username";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery =session.createQuery(hql, User.class);
        typedQuery.setParameter("username",username);
        User user1 =typedQuery.getSingleResult();

        System.out.println(user1);
        return Optional.ofNullable(user1);
    }

    public List<Name> findAllName(){
        // String sql = " select u.firstname,u.middlename,u.lastname from tbl_user as u "
        String hql = "select u.name from User as u";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Name> typedQuery =session.createQuery(hql, Name.class);
        List<Name> nameList = typedQuery.getResultList();

        return nameList;
    }
    public List<String> findAllFirstName(){
        // String sql = " select u.firstname from tbl_user as u "
        String hql = "select u.name.firstName from User as u";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<String> typedQuery =session.createQuery(hql, String.class);
        List<String> nameList = typedQuery.getResultList();
        //List<String> firstNameList = nameList.stream().map(x->x.getFirstName()).collect(Collectors.toList());

        return nameList;
    }

    public List<User> mostPostUser(){
        // String sql = " select u.firstname from tbl_user as u "
        String hql = "select u from User as u where postCount =(select max(postCount) from User)";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<User> typedQuery =session.createQuery(hql, User.class);
        List<User> userList= typedQuery.getResultList();
        userList.forEach(System.out::println);

        return userList;
    }
   // "select u from User u where u.id = (select p.userId from Post p where p.id ="+postId+")"
    public List<Object[]> mostPostUser2(){
        // String sql = " select u.firstname from tbl_user as u "
        String hql = "select u from User as u where postCount =(select max(postCount) from User)";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Object[]> typedQuery =session.createQuery(hql, Object[].class);
        List<Object[]> userList= typedQuery.getResultList();
        userList.forEach(System.out::println);

        return userList;
    }


}
