package com.onurbas;

import com.onurbas.controller.BookController;
import com.onurbas.repository.BookRepository;
import com.onurbas.repository.BorrowRepository;

/*
  1- turu novel olan kitapların listesi;
  2-ismi a ile başayan yazarların kitaplarını getirelim;


 */
public class MainHql {

    public static void main(String[] args) {

        BookController bookController=new BookController();
        BookRepository bookRepository=new BookRepository()
                ;
        //bookController.getBooksByType(EBookType.NOVEL).forEach(System.out::println);
 //   bookRepository.getBooksByType().forEach(System.out::println);
   // bookRepository.getBooksWithAuthorNameStartWith("A").forEach(System.out::println);
  //  bookRepository.getBooksByTypeWithCriteria(EBookType.NOVEL).forEach(System.out::println);
    //bookRepository.getBooksByTypeNamedQuery(EBookType.NOVEL).forEach(System.out::println);
     //   bookRepository.getBooksByTitle("Son Kuşlar").forEach(System.out::println);

        BorrowRepository borrowRepository = new BorrowRepository();
      //  borrowRepository.getBorrowByUserId(1L).forEach(System.out::println);
        borrowRepository.findUserByBorrowedBook2(1L).forEach(System.out::println);

    }


}
