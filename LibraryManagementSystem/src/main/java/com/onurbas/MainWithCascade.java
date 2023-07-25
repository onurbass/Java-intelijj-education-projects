package com.onurbas;

import com.onurbas.repository.UsersRepository;

public class MainWithCascade {
    public static void main(String[] args) {
        UsersRepository userRepository=new UsersRepository();


//        Users user=Users.builder().password("123").username("musty")
//                .userInformation(UserInformation.builder().firstName("Mustafa").lastName("Ozturk")
//                        .address(Address.builder().city("Ankara").country("Türkiye").build()).build()).build();
//        userRepository.save(user);


    }
}