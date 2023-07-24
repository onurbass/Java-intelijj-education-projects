package com.onurbas.controller;

import com.onurbas.repository.ICrud;
import com.onurbas.repository.entity.Borrow;
import com.onurbas.service.BorrowService;

import java.util.List;
import java.util.Optional;

public class BorrowController implements ICrud<Borrow> {
    BorrowService borrowService;


    public BorrowController() {
        this.borrowService=new BorrowService();
    }

    @Override
    public Borrow save(Borrow borrow) {
        borrowService.setReturnDate(borrow);
        return borrowService.save(borrow);
    }

    @Override
    public Borrow update(Borrow borrow) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Borrow> findAll() {
        return null;
    }

    @Override
    public Optional<Borrow> findById(Long id) {
        return Optional.empty();
    }


}
