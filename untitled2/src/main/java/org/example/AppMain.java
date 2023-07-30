package org.example;

import org.example.entity.Person;
import org.example.entity.Rental;
import org.example.utility.AppMenu;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class AppMain {
    public static void main(String[] args) {
//        Rental rental=new Rental();
//        Person person= Person.builder().firstName("Serkan").surname("Zorlu").build();
//        person.getRentalList().add(rental);

        AppMenu appMenu=new AppMenu();
        appMenu.mainMenu();
    }
}