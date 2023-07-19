package com.onurbas;


import com.onurbas.controller.PostController;
import com.onurbas.controller.UserController;
import com.onurbas.repository.PostRepository;
import com.onurbas.repository.entity.Address;
import com.onurbas.repository.entity.Name;
import com.onurbas.repository.entity.Post;
import com.onurbas.repository.entity.User;
import com.onurbas.repository.enums.EAddress;
import com.onurbas.repository.enums.EGender;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Name name = new Name("Osman", "Onur", "Baş");



        User user = User.builder()
                .name(name)
                .username("onurbass")
                .password("123456")
                .gender(EGender.MEN)
                .age(26)
                .build();
       Set<String> ilgi = new HashSet<>();

        user.getIlgiAlanları().add("Muzik");
        user.getIlgiAlanları().add("Spor");
        user.getIlgiAlanları().add("Sinema");
        user.getIlgiAlanları().add("oyun");
        Address address = new Address("Sinop","Turkey");
        user.getAdressler().put(EAddress.EV,address);

//        Session session = null;
//        Transaction transaction = null;
//
//        try {
//            session = HibernateUtility.getSessionFactory().openSession();
//            transaction = session.beginTransaction();
//            session.save(user);
//            transaction.commit();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            transaction.rollback();
//        }
        UserController userController = new UserController();
        userController.save(user);
        PostController postController = new PostController();
        Post post = Post.builder().content("onur").user_id(user.getId()).build();
        postController.save(post);
   }
}