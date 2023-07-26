package com.onurbas;

import com.onurbas.controller.BookController;
import com.onurbas.controller.BorrowController;
import com.onurbas.repository.BookRepository;
import com.onurbas.repository.BorrowRepository;
import com.onurbas.repository.entity.Book;
import com.onurbas.repository.entity.Borrow;
import com.onurbas.repository.entity.Users;
import com.onurbas.repository.enums.EStatus;
import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class MainHql {

    public static void main(String[] args) {

        BookController bookController = new BookController();
        BookRepository bookRepository = new BookRepository();
        //bookController.getBooksByType(EBookType.NOVEL).forEach(System.out::println);
        //   bookRepository.getBooksByType().forEach(System.out::println);
        // bookRepository.getBooksWithAuthorNameStartWith("A").forEach(System.out::println);
        //  bookRepository.getBooksByTypeWithCriteria(EBookType.NOVEL).forEach(System.out::println);
        //bookRepository.getBooksByTypeNamedQuery(EBookType.NOVEL).forEach(System.out::println);
        //   bookRepository.getBooksByTitle("Son Kuşlar").forEach(System.out::println);

        BorrowRepository borrowRepository = new BorrowRepository();
        //  borrowRepository.getBorrowByUserId(1L).forEach(System.out::println);
        // borrowRepository.findUserByBorrowedBook2(1L).forEach(System.out::println);
        MainHql mainHql = new MainHql();
        // mainHql.kitapListele().forEach(x-> System.out.println(x.getId()+" - "+x.getTitle()));
        //mainHql.kitapSec();
      bookController.kiralamaYap();
    }

    /*

7- Odunc alma metodu ==>
bir kiralanabilir kitapları listeliyeceğiz
daha sonra bir kullanıcı bilgisi alacagız
daha sonra kaç gun kiralamak istediğmizi gireceğiz ve sonunda bir kiralama gerçekleştireceğiz
(Uyarı: kiralama sonucu gerçekleşen değişklikleri databsede guncellemeyi unutmayın )
*/
    public List<Book> kitapListele() {
        String hql = "select b from Book b where b.status = 'AVAILABLE'";
        List<Book> list = null;
        try (Session session = HibernateUtility.getSESSION_FACTORY().openSession()) {
            TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);

            list = typedQuery.getResultList();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public Book kitapSec() {
        List<Book> avaibleBooks = kitapListele();
        avaibleBooks.forEach(x -> System.out.println(x.getId() + " - " + x.getTitle()));
        System.out.println("Kitap id seçiniz");
        Scanner scanner = new Scanner(System.in);
        String secilenKitap = scanner.nextLine();
        Book book = null;
        String hql = "select b from Book as b where b.id=" + Integer.parseInt(secilenKitap);
        try (Session session = HibernateUtility.getSESSION_FACTORY().openSession()) {
            TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);

            book = typedQuery.getSingleResult();
            System.out.println("Secilen kitap->" + book);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (book == null) {
            System.out.println("Hatalı giriş");
            throw new RuntimeException();

        } else return book;
    }

    public List<Users> userListele() {
        String hql = "select u from Users u";
        List<Users> list = null;
        try (Session session = HibernateUtility.getSESSION_FACTORY().openSession()) {
            TypedQuery<Users> typedQuery = session.createQuery(hql, Users.class);

            list = typedQuery.getResultList();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public Users userSec() {
        List<Users> users = userListele();
        users.forEach(x -> System.out.println(x.getId() + " - " + x.getUsername()));
        System.out.println("User id seçiniz");
        Scanner scanner = new Scanner(System.in);
        String secilenUser = scanner.nextLine();
        Users user = null;
        String hql = "select u from Users as u where u.id=" + Integer.parseInt(secilenUser);
        try (Session session = HibernateUtility.getSESSION_FACTORY().openSession()) {
            TypedQuery<Users> typedQuery = session.createQuery(hql, Users.class);

            user = typedQuery.getSingleResult();
            System.out.println("Secilen kisi ->" + user);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (user == null) {
            System.out.println("Hatalı giriş");
            throw new RuntimeException();
        } else return user;

    }

    public void kiralamaYap() {
        BorrowController borrowController = new BorrowController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kaç gün kiralanacak");
        String period = scanner.nextLine();
        Users users = userSec();
        Book book = kitapSec();
        Borrow borrow = Borrow.builder()
                .book(book)
                .users(users)
                .borrowDate(LocalDate.now())
                .period(Integer.parseInt(period))
                .build();
        book.setStatus(EStatus.UNAVAILABLE);
       // borrow.setReturnDate(LocalDate.now().plusDays(Long.parseLong(period)));
        borrowController.save(borrow);


    }
}
