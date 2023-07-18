package com.onurbas;

import com.onurbas.model.Customer;
import com.onurbas.model.CustomerDetail;
import com.onurbas.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

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
            session.save(customer);
            session.save(customer2);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println("Hata: " + e);
        } finally {
            session.close();
        }
    }
}
