package com.onurbas.controller;

import com.onurbas.repository.entity.Book;
import com.onurbas.repository.entity.Borrow;
import com.onurbas.repository.entity.Users;
import com.onurbas.repository.enums.EBookType;
import com.onurbas.repository.enums.EStatus;
import com.onurbas.service.BookService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import javax.persistence.TypedQuery;

import com.onurbas.utility.HibernateUtility;
import org.hibernate.Session;

import java.util.List;

public class BookController {
    private BookService bookService;
    public BookController() {
        this.bookService = new BookService();
    }

    public Book save(Book book){
        return   bookService.save(book);
    }

    public Book update(Book book) {
        return  bookService.update(book);
    }

    public List<Book> getBooksByType(EBookType type){
        return bookService.getBooksByType(type);
    }



    private Session openSession() {
        return HibernateUtility.getSESSION_FACTORY().openSession();
    }

    public List<Book> kitapListele() {
        String hql = "select b from Book b where b.status = 'AVAILABLE'";
        try (Session session = openSession()) {
            TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);
            return typedQuery.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public Book kitapSec() {
        List<Book> availableBooks = kitapListele();
        availableBooks.forEach(x -> System.out.println(x.getId() + " - " + x.getTitle()));
        System.out.println("Kitap id seçiniz");
        Scanner scanner = new Scanner(System.in);
        String secilenKitapId = scanner.nextLine();
        try (Session session = openSession()) {
            Book book = session.get(Book.class, Long.parseLong(secilenKitapId));
            if (book == null || book.getStatus() != EStatus.AVAILABLE) {
                System.out.println("Hatalı giriş veya kitap mevcut değil.");
                throw new RuntimeException();
            }
            return book;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }


    public List<Users> userListele() {
        String hql = "select u from Users u";
        try (Session session = openSession()) {
            TypedQuery<Users> typedQuery = session.createQuery(hql, Users.class);
            return typedQuery.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public Users userSec() {
        List<Users> users = userListele();
        users.forEach(x -> System.out.println(x.getId() + " - " + x.getUsername()));
        System.out.println("User id seçiniz");
        Scanner scanner = new Scanner(System.in);
        String secilenUserId = scanner.nextLine();
        try (Session session = openSession()) {
            Users user = session.get(Users.class, Long.parseLong(secilenUserId));
            if (user == null) {
                System.out.println("Hatalı giriş veya kullanıcı mevcut değil.");
                throw new RuntimeException();
            }
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void kiralamaYap() {
        BorrowController borrowController = new BorrowController();
        Scanner scanner = new Scanner(System.in);
        Users users = userSec();
        Book book = kitapSec();
        System.out.println("Kaç gün kiralanacak");
        int period = scanner.nextInt();
        Borrow borrow = Borrow.builder()
                .book(book)
                .users(users)
                .borrowDate(LocalDate.now())
                .period(period)
                .build();
        book.setStatus(EStatus.UNAVAILABLE);
        borrowController.save(borrow);
    }
}
