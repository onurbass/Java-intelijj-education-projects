package com.onurbas;

import com.onurbas.repository.UsersRepository;
import com.onurbas.repository.entity.Address;
import com.onurbas.repository.entity.UserInfo;
import com.onurbas.repository.entity.Users;

import java.util.Set;

public class Main {
    public static void main(String[] args) {


        UsersRepository usersRepository = new UsersRepository();
        Users user = Users.builder().username("onurbass").password("1234").userInfo(UserInfo.builder()
                .firstName("onur").about("sa").phone("555").address((Set<Address>) Address.builder().city("Sinop")
                        .country("Turkey").build()).lastName("baş").build()).build();
        usersRepository.save(user);
    }
}