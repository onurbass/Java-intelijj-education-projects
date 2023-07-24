package com.onurbas.utility;

import com.onurbas.controller.BookController;
import com.onurbas.controller.BorrowController;
import com.onurbas.controller.UsersController;

import com.onurbas.repository.entity.*;
import com.onurbas.repository.enums.EBookTypes;
import com.onurbas.repository.enums.EStatus;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.DoubleStream;

public class CreateData {
    public  static  void createData(){

        Author author= Author.builder().firstName("KEMAL").lastName("TAHIR").build();
       
 BookController bookController=new BookController();
        Book book=Book.builder().
                title("Hür Sehrin insanları").bookType(EBookTypes.HISTORY).author(author).build();
        Book book2=Book.builder().
                title("Esir Sehrin insanları").bookType(EBookTypes.HISTORY).author(author).build();
        Book book3=Book.builder().
                title("Yorgun savascı").bookType(EBookTypes.HISTORY).author(author).build();

        bookController.save(book);
        bookController.save(book2);
        bookController.save(book3);

        Author author1= Author.builder().firstName("Albert").lastName("Camus").build();
        Book book4= Book.builder().title("Yabancı").bookType(EBookTypes.NOVEL).author(author1).build();
        Book book5= Book.builder().title("Mutlu ölüm").bookType(EBookTypes.NOVEL).author(author1).build();
        Book book6= Book.builder().title("Sisifos Söyleni").bookType(EBookTypes.NOVEL).author(author1).build();

        bookController.save(book4);
        bookController.save(book5);
        bookController.save(book6);
     
//
        Author author3= Author.builder().firstName(" Sait Faik").lastName("Abasıyanık").build();
        Book book7= Book.builder().title("Son Kuşlar").bookType(EBookTypes.STORY).author(author3).build();
        Book book8= Book.builder().title("Yabancı").bookType(EBookTypes.STORY).author(author3).build();
        bookController.save(book7);
        bookController.save(book8);

        Author author4= Author.builder().firstName("Nikolay").lastName("Gogol").build();
        Book book9= Book.builder().title("Ölü Canlar").bookType(EBookTypes.NOVEL).author(author4).build();
        bookController.save(book9);
		
		
        Author author5= Author.builder().firstName("Erich").lastName("From").build();

        Book book10= Book.builder().title("Özgürlükten Kaçış").bookType(EBookTypes.NOVEL).author(author5).build();
        Book book11= Book.builder().title("SEvme SAnatı").bookType(EBookTypes.NOVEL).author(author5).build();
        bookController.save(book10);
        bookController.save(book11);
        //// users olusturma
        Address address1=Address.builder().country("Turkiye").city("Ankara").build();
        Address address2=Address.builder().country("Türkiye").city("Balıkesir").build();
        Address address3=Address.builder().country("Türkiye").city("Konya").build();
        Address address4=Address.builder().country("Türkiye").city("İzmir").build();
        Address address5=Address.builder().country("Türkiye").city("Amasya").build();
        Address address6=Address.builder().country("Türkiye").city("Erzincan").build();

           
           UserInfo usersInfo=UserInfo.builder().firstName("Mustafa")
                .lastName("Ozturk")

                .phone("5555-555-55-5")
                .about("hakkımda........")
                .address(Set.of(address1 ,address2))
                .build();

        UserInfo usersInfo2= UserInfo.builder().firstName("Tuba")
                .lastName("Ozturk")

                .phone("5555-555-55-5")
                .about("hakkımda........")
                .address(Set.of(address1 ,address3,address4))
                .build();
        UserInfo usersInfo3=UserInfo.builder().firstName("Derya")
                .lastName("Ozturk")

                .phone("5555-555-55-5")
                .about("hakkımda........")
                .address(Set.of(address5 ,address6))
                .build();

        Users users= Users.builder().username("musty").password("123")
                .userInfo(usersInfo)
                .build();
        Users users2=Users.builder().username("tuba").password("123").userInfo(usersInfo2).build();
        Users users3=Users.builder().username("derya").password("123").userInfo(usersInfo3).build();
        //
        UsersController usersController=new UsersController();
        usersController.save(users);
        usersController.save(users2);
        usersController.save(users3);



        Borrow borrow1= Borrow.builder()
                .book(book)
                .users(users)
                .period(5)
                .borrowDate(LocalDate.now().minusDays(8))
                .build();
        /// once 5 gunluk kiralama yaptık
        book.setStatus(EStatus.UNAVAILABLE);
        bookController.update(book);
        // daha sonra 5 gun sonra kiralanan kitabın geri iade oldugu bir senaryo olusturduk
        book.setStatus(EStatus.AVAILABLE);
        bookController.update(book);
        //daha sonra aynı kitabı başka bir kullanıcı tekrardan kiraldı
        Borrow borrow2= Borrow.builder()
                .book(book)
                .users(users2)
                .period(5)
                .borrowDate(LocalDate.now().minusDays(2))
                .build();
        book.setStatus(EStatus.UNAVAILABLE);
        bookController.update(book);
        Borrow borrow3= Borrow.builder()
                .book(book6)
                .users(users)
                .period(10)
                .build();
        book6.setStatus(EStatus.UNAVAILABLE);
        bookController.update(book6);
        Borrow borrow4= Borrow.builder()
                .book(book5)
                .users(users)
                .period(10)
                .build();
        book5.setStatus(EStatus.UNAVAILABLE);
        bookController.update(book5);
        BorrowController borrowController=new BorrowController();
        borrowController.save(borrow1);
        borrowController.save(borrow2);
        borrowController.save(borrow3);
        borrowController.save(borrow4);

    }

       public static void main(String[] args) {
              createData();
       }
}
