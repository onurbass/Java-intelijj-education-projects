package com.onurbas;

import com.onurbas.model.Customer;
import com.onurbas.model.CustomerDetail;
import com.onurbas.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class AppMain {

    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setTitle("Prof");
        customer.setFirstname("Burak");
        customer.setLastname("Delice");

        CustomerDetail customerDetail = new CustomerDetail();

        customerDetail.setAddress("Ankara");
        customerDetail.setCreationDate(new Date());
        customerDetail.setPhone("551");
        customerDetail.setCustomer(customer);

        Customer customer2 = Customer.builder().title("Dr").firstname("Onur").lastname("Baş").build();
        CustomerDetail customerDetail1 = CustomerDetail.builder().phone("555").address("Sinop").creationDate(new Date()).build();
        customerDetail1.setCustomer(customer2);

        customer.setCustomerDetail(customerDetail);
        customer2.setCustomerDetail(customerDetail1);

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
          //  session.save(customer);
          //  session.save(customer2);
            Query query = session.createQuery("from Customer");
            List<Customer> customerList = query.list();
            for (Customer c:customerList
                 ) {
                System.out.println(c.getTitle()+" " +c.getFirstname()+" "+ c.getLastname());

            }
            System.out.println("============where id 1 ====================");
            Query query2 = session.createQuery("from Customer where id=:id");
            query2.setLong("id",1);
          Customer customerDemo =(Customer) query.uniqueResult();
            System.out.println(customerDemo.getTitle()+" " +customerDemo.getFirstname()+" "+ customerDemo.getLastname());

            System.out.println("=====update====");
            query=session.createQuery("update Customer set firstname=:first_name," +
                    "lastname=:last_name,title=:title where  id=:id");
        query.setParameter("title","Ogr");
        query.setParameter("first_name","amine");
        query.setParameter("last_name","goynuk");

            query.setLong("id",2);
            int result=query.executeUpdate();
            System.out.println(result);
        //    Customer customerDemo2 =(Customer) query.uniqueResult();
//            System.out.println(customerDemo2.getTitle()+" " +customerDemo2.getFirstname()+" "+ customerDemo2.getLastname());


            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println("Hata: " + e);

        } finally {
            session.close();
        }
    }
}
