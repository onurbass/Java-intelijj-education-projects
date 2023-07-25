package com.onurbas;

import com.onurbas.controller.AddressController;
import com.onurbas.controller.UserInformationController;
import com.onurbas.repository.entity.Address;
import com.onurbas.repository.entity.UserInformation;

import java.util.Set;

public class MainManytoMany {


    public static void main(String[] args) throws InterruptedException {
        UserInformationController userInformationController=new UserInformationController();
        AddressController addressController=new AddressController();

        Address address1= Address.builder().city("Ankara").build();
        Address address2= Address.builder().city("Bolu").build();

        UserInformation userInformation1=UserInformation.builder().firstName("Mustafa")
                .address(Set.of(address1,address2)).build();

        UserInformation userInformation2=UserInformation.builder().firstName("Kemal")
                .address(Set.of(address1,address2)).build();
//        address1.getUserInformations().add(userInformation1);
//        address1.getUserInformations().add(userInformation2);
//        address2.getUserInformations().add(userInformation1);
//        address2.getUserInformations().add(userInformation2);
        userInformationController.save(userInformation1);
        userInformationController.save(userInformation2);

        Thread.sleep(2000);

        userInformationController.findAll().forEach(System.out::println);


    }
}
