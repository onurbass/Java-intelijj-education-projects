package com.onurbas.controller;

import com.onurbas.repository.ICrud;
import com.onurbas.repository.entity.Address;
import com.onurbas.service.AddressService;

import java.util.List;
import java.util.Optional;

public class AddressController implements ICrud<Address> {
    AddressService addressService;


    public AddressController() {
        this.addressService=new AddressService();
    }

    @Override
    public Address save(Address adress) {
        return null;
    }

    @Override
    public Address update(Address adress) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Optional<Address> findById(Long id) {
        return Optional.empty();
    }
}
