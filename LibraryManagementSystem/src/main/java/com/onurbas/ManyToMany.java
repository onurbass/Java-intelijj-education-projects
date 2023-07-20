package com.onurbas;

import com.onurbas.controller.AddressController;
import com.onurbas.controller.UserInfoController;
import com.onurbas.repository.entity.Address;
import com.onurbas.repository.entity.UserInfo;
import com.onurbas.repository.entity.Users;

import java.util.Set;

public class ManyToMany {
    public static void main(String[] args) throws InterruptedException {
        Address address = Address.builder().city("Ankara").country("Turkey").build();
        Address address2 = Address.builder().city("eses").country("Turkey").build();
        UserInfo userInfo = UserInfo.builder().firstName("mustafa").address(Set.of(address,address2)).build();
        UserInfo userInfo2 = UserInfo.builder().firstName("onur").address(Set.of(address,address2)).build();
        UserInfoController userInfoController = new UserInfoController();
        AddressController addressController = new AddressController();
        Users users2= Users.builder().username("onurbass").password("1234").build();
        address.getUserInfos().add(userInfo);
        address.getUserInfos().add(userInfo2);
        address2.getUserInfos().add(userInfo);
        address2.getUserInfos().add(userInfo2);

        userInfoController.save(userInfo);
        userInfoController.save(userInfo2);
        Thread.sleep(2000);
        userInfoController.findAll().forEach(System.out::println);

    }


}
