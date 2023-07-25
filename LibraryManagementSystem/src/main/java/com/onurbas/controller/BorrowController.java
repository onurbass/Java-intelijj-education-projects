package com.onurbas.controller;

import com.onurbas.repository.entity.Borrow;
import com.onurbas.service.BorrowService;

public class BorrowController {

  private BorrowService borrowService;

    public BorrowController() {
        this.borrowService = new BorrowService();
    }

    public Borrow save(Borrow borrow){
      borrowService.saveReturnDate(borrow);
      return   borrowService.save(borrow);
    }

}
