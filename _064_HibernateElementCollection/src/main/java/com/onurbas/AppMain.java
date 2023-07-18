package com.onurbas;

import com.onurbas.model.Address;
import com.onurbas.model.Customer;
import com.onurbas.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class AppMain {

    public static void main(String[] args) {

        Customer customer=new Customer();
        customer.setFirstname("Onur");
        customer.setLastname("Baş");

            Address address = new Address();
            address.setSehir("Ankara");
            address.setIlce("Aşağı Ayrancı");
            address.setMahalle("Yukarı Ayrancı");

        customer.setAddress(address);
        customer.setCreationDate(new Date());

        customer.getAdresListesi().add(address);
//-----------------------------------------------------------

        Address address2 = new Address("Adana", "Tarsus", "Seyhan");

        Customer customer2 = new Customer("Engin", "Ertikmen", address2, new Date());
        customer2.getAdresListesi().add(address2);

        Session session= HibernateUtil.getSessionFactory().openSession();

        Transaction transaction=null;

        try{
            transaction=session.beginTransaction();
                session.save(customer);
                session.save(customer2);
            transaction.commit();

        }catch(HibernateException e){
            transaction.rollback();
            System.out.println("Hata: "+e);
        }
        finally {
            session.close();
        }

    }

}
