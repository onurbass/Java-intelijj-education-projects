package com.onurbas.controller;

import com.onurbas.repository.entity.Address;
import com.onurbas.service.AddressService;

public class AddressController {

    private AddressService addressService;

    public AddressController() {
        this.addressService = new AddressService();

    }

    public Address save(Address address){
        return  addressService.save(address);
    }
}
