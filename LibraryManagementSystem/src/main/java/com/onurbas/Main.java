package com.onurbas;

import com.onurbas.repository.AddressRepository;
import com.onurbas.repository.UserInformationRepository;
import com.onurbas.repository.UsersRepository;
import com.onurbas.repository.entity.Address;
import com.onurbas.repository.entity.UserInformation;
import com.onurbas.repository.entity.Users;

public class Main {
    public static void main(String[] args) {
        UsersRepository userRepository=new UsersRepository();
        UserInformationRepository userInformationRepository=new UserInformationRepository();
        /// adress kayıt işlemi
        AddressRepository addressRepository=new AddressRepository();
        Address address= Address.builder().city("Ankara").country("Türkiye").build();
        addressRepository.save(address);
        // user informatiın kayıt işlemi
     UserInformation userInformation   =UserInformation.builder().firstName("Mustafa").lastName("Ozturk").build();
     userInformationRepository.save(userInformation);
        // user kayıt işlemi
        Users user=Users.builder().password("123").username("musty")
                .userInformation(userInformation).build();
        userRepository.save(user);

        Users users2=Users.builder().password("456").username("mustafa").build();
       userRepository.save(users2);




    }
}