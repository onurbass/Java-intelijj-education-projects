package com.onurbas;

import com.onurbas.repository.AddressRepository;
import com.onurbas.repository.UserInfoRepository;
import com.onurbas.repository.UserRepository;
import com.onurbas.repository.entity.Address;
import com.onurbas.repository.entity.UserInfo;
import com.onurbas.repository.entity.Users;

public class Main {
    public static void main(String[] args) {


        UserRepository userRepository = new UserRepository();
        Users user = Users.builder().username("onurbass").password("1234").userInfo(UserInfo.builder().firstName("onur").about("sa").phone("555").address(Address.builder().city("Sinop").country("Turkey").build()).lastName("baş").build()).build();
        userRepository.save(user);
    }
}